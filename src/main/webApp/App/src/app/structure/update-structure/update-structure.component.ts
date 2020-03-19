import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Structure, StructureType} from "../../model/structure";
import {StructureService} from "../structure.service";
import {Speciality} from "../../model/speciality";
import {SpecialityService} from "../../speciality/speciality.service";
import {Dmp} from "../../model/dmp";
import {Profil} from "../../model/profil";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DialogChefComponent} from "../dialog-overview/dialog-chef.component";

@Component({
  selector: 'app-update-structure',
  templateUrl: './update-structure.component.html',
  styleUrls: ['./update-structure.component.css']
})
export class UpdateStructureComponent implements OnInit {
  id:number;
  formGroup: FormGroup;
  type=[ StructureType.FUNCTIONAL_UNIT,StructureType.HOSPITAL,StructureType.POLE,StructureType.SERVICE,StructureType.HOSPITAL_UNIT];
  @Output()
  updateStructure=new EventEmitter<Structure>();
  @Output()
  affectChief = new EventEmitter<Boolean>();
  key: string;
  listSpecialities: Array<Speciality> = [];
  structure:Structure;
  listStructures: Array<Structure> = [];
  profils: Array<Profil>;
  idProfil: number;
  chief: Profil;
  constructor(private structureService : StructureService,
              private route: ActivatedRoute,
              protected router: Router,
              private dialog: MatDialog,
              private specialityService:SpecialityService) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];
    this.structureService.getParentFromStructure(this.id, this.key).subscribe(
      data3 => {
        this.structureService.getSpecialityFromStructure(this.id,this.key).subscribe(
          data2=>{
            this.structureService.getStructure(this.id,this.key).subscribe(data => {
              this.structure=data;
              this.onGetSpeciality();
              this.onGetStructures();
              this.onGetProfils();
              this.formGroup = new FormGroup({
                name: new FormControl(data.name),
                description: new FormControl(data.description),
                type: new FormControl(data.type),
                speciality: new FormControl(data2.name),
                parent: new FormControl(data3),
              });
              this.chief = this.structure.chief;
            });
          }
        )
      }
    )

  }
  updateForm(){
    console.log("yooooo");
    console.log(this.findIndiceOfSpeciality(this.structure.speciality))
    console.log("yooooo");

    this.formGroup.patchValue({
      speciality : this.listSpecialities[this.findIndiceOfSpeciality(this.structure.speciality)],
      parent : this.listStructures[this.findIndiceOfStructure(this.structure.parent)],
    });
  }


  findIndiceOfSpeciality(speciality: Speciality) {

    for(let i = 0; i < this.listSpecialities.length; i++)
      if(this.listSpecialities[i].id == speciality.id)
        return i;


    return 0;
  }

  findIndiceOfStructure(parent: Structure) {
    for(let i = 0; i < this.listStructures.length; i++)
      if(this.listStructures[i].id == parent.id)
        return i;
    return 0;
  }
  onGetProfils(){
    this.structureService
      .getProfils(this.key)
      .subscribe(
        data=>{this.profils=data;},
        error => {console.log(error);
        })
  }
  onGetStructures(){
    this.structureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.listStructures=data;          this.updateForm();
        },
        error => {console.log(error);
        })
  }
  onGetSpeciality(){;
    console.log("get spéciality")
    this.specialityService
      .getSpecialities(this.key)
      .subscribe(
        data=>{this.listSpecialities=data;console.log("specialityyyyyyyy",data);          this.updateForm();
        },
        error => {console.log(error);
        })
  }
  onUpdateStructure() {
    let structure: Structure =  this.formGroup.value;
    structure.id = this.id;
    this.structureService.updateStructure(structure,this.key).subscribe(
      data => {this.updateStructure.emit(structure),
        this.structureService.changeParent(this.key, this.id, this.formGroup.get("parent").value.id).subscribe(
          data =>  this.router.navigate(['/structures/'+this.key])
        )},
      error => console.log(error)
    );}

  affecteChief(id:any) :void {
    const  dialogConfig  =  new  MatDialogConfig ( ) ;
    dialogConfig . disableClose  =  true ;
    dialogConfig . id  =  "composant modal" ;
    dialogConfig .height  =  "350 px" ;
    dialogConfig . width  =  "600px" ;
    const dialogRef = this.dialog.open(DialogChefComponent,{
      width:"350",height:"600",
      data:this.profils,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.idProfil = result.data;
      this.structureService
        .affecteProfil(this.key,id, this.idProfil)
        .subscribe(
          data=>{
            //this.affectChief.emit(true);
            this.onGetProfils();
            this.refreshList();
          },
          error => {console.log("errrrrrror affectation chief",error)}
        );
    });
  }
  refreshList(){
    this.structureService.getStructure(this.id,this.key).subscribe(data => {
        this.chief=data.chief;

      }
    );
  }

  deleteChefStructure($event: any) {

  }
}
