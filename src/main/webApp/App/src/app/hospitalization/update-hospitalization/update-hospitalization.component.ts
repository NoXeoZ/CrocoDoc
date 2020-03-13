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
        this.formGroup = new FormGroup({
          dmp: new FormControl(data.dmp),
          hospital: new FormControl(data.hospital),
          startDate: new FormControl(data.startDate),
          endDate: new FormControl(data.endDate),
        });
      });
    this.onGetDmps();
    this.onGetStructures();
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
        data=>{this.listStructures=data,console.log(data)},
        error => {console.log(error);
        })
  }

  createHospitalization(id:any) :void {
    const  dialogConfig  =  new  MatDialogConfig ( ) ;
    dialogConfig . disableClose  =  true ;
    dialogConfig . id  =  "composant modal" ;
    dialogConfig .height  =  "350 px" ;
    dialogConfig . width  =  "600px" ;
    const dialogRef = this.dialog.open(DialogOverviewAssignementComponent,{
      width:"350",height:"600",
      data:this.listStructures,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.assignement = result.data;
      console.log("data reçu  service=>  "+this.assignement.service);
      this.hospitalizationService
        .createAssignement(this.key, this.assignement)
        .subscribe(
          data=>{this.createAssignement.emit(true);
            this.onGetStructures();
            this.refreshList();
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

}
