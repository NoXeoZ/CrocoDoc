import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Hospitalization} from "../../model/Hospitalization";
import {HospitalizationService} from "../hospitalization.service";
import {Dmp} from "../../model/dmp";
import {DmpSecretaryService} from "../../dmp-admin/dmp-secretary.service";
import {StructureService} from "../../structure/structure.service";
import {Structure} from "../../model/structure";
import {MatDialog, MatDialogConfig} from '@angular/material';
import {DialogOverviewAssignementComponent} from '../dialog-overview-assignement/dialog-overview-assignement.component';
import {Assignement} from '../../model/assignement';

@Component({
  selector: 'app-update-hospitalization',
  templateUrl: './update-hospitalization.component.html',
  styleUrls: ['./update-hospitalization.component.css']
})
export class UpdateHospitalizationComponent implements OnInit {
  id:number;
  dmps:Array<Dmp>;
  formGroup: FormGroup;
  hosp:Hospitalization;
  @Output()
  updateHospitalization=new EventEmitter<Hospitalization>();
  private key: string;
  private listStructures: Array<Structure>;
  private assignement: Assignement;
  @Output()
  createAssignement=new EventEmitter<boolean>();
  private listAssignement: Array<Assignement>;

  constructor(private hospitalizationService : HospitalizationService,
              private dmpAdminService:DmpSecretaryService,
              private route: ActivatedRoute,
              private dialog: MatDialog,
              private structureService:StructureService) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];
    this.hospitalizationService.getHospitalization(this.id,this.key).subscribe(data => {
      this.hosp=data;

      this.hospitalizationService.getDmpOfHospitalization(this.key, this.id).subscribe(
        data2 => {
          this.hosp.dmp = data2;
          this.hospitalizationService.getHospitalOfHospitalization(this.key, this.id).subscribe(
            data3 => {
              this.hosp.hospital = data3;
              console.log(this.hosp);
              this.formGroup = new FormGroup({
                dmp: new FormControl(this.hosp.dmp),
                hospital: new FormControl(this.hosp.hospital),
                startDate: new FormControl(new Date(data.startDate).toISOString().substring(0,10)),
                endDate: new FormControl(new Date(data.endDate).toISOString().substring(0,10)),
              });
              this.updateForm();
            }
          )


        }
      )
      console.log("data"+this.hosp.hospital);
      console.log(this.hosp);

    });
    this.onGetDmps();
    this.onGetStructures();
    this.refreshList();
  }
  onGetDmps(){
    this.dmpAdminService
      .getDmps(this.key)
      .subscribe(
        data=>{this.dmps=data;},
        error => {console.log(error);
        })
  }
  onUpdateHospitalization() {
    let hospitalization: Hospitalization =  this.formGroup.value;
    hospitalization.id = this.id;
    this.hospitalizationService.updateHospitalization(hospitalization,this.key).subscribe(
      data => this.updateHospitalization.emit(hospitalization),
      error => console.log(error)
    );}
  onGetStructures(){
    this.structureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.listStructures=data,console.log("structure"+data)},
        error => {console.log(error);
        })
  }

  createHospitalization(id:any) :void {
    const  dialogConfig  =  new  MatDialogConfig ( ) ;
    dialogConfig . disableClose  =  true ;
    dialogConfig . id  =  "composant modal" ;
    dialogConfig .height  =  "350 px" ;
    dialogConfig . width  =  "600px" ;
    console.log(this.listStructures.length)

    let lst = Object.assign([], this.listStructures);
    // pour éviter la boucle infini
    for(let i = 0; i < lst.length; i++){
      if(lst[i].id == this.hosp.hospital.id){
        lst.splice(i, 1);
        i--;
      }
    }
    const dialogRef = this.dialog.open(DialogOverviewAssignementComponent,{
      width:"350",height:"600",
      data:lst,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.assignement = result.data;
      this.assignement.hospitalization = this.hosp;
      console.log("data reçu  service=>  "+this.assignement.service);
      this.hospitalizationService
        .createAssignement(this.key, this.assignement)
        .subscribe(
          data=>{
            console.log("works");
            this.createAssignement.emit(true);
            //this.onGetStructures();
            this.refreshList();

            console.log(this.listStructures.length)
            console.log(data);
          },
          error => {console.log("errrrrrror",error)}
        );
    });
  }
  private refreshList() {
    this.hospitalizationService.getHospitalization(this.id,this.key).subscribe(data => {
        this.listAssignement=data.assignments;

      }
    );
  }

  updateForm(){
    this.formGroup.patchValue({
      dmp : this.dmps[this.findIndiceOfDMP(this.hosp.dmp)],
      hospital : this.listStructures[this.findIndiceOfHospital(this.hosp.hospital)]
    })
  }

  findIndiceOfDMP(dmp: Dmp) {
    for(let i = 0; i < this.dmps.length; i++)
      if(this.dmps[i].id == dmp.id)
        return i;
    return 0;
  }


  findIndiceOfHospital(hospital: Structure) {
    for(let i = 0; i < this.listStructures.length; i++)
      if(this.listStructures[i].id == hospital.id)
        return i;
    return 0;
  }
}
