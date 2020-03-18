import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Structure, StructureType} from "../../model/structure";
import {StructureService} from "../structure.service";
import {Speciality} from "../../model/speciality";
import {SpecialityService} from "../../speciality/speciality.service";
import {Dmp} from "../../model/dmp";

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
  key: string;
  listSpecialities: Array<Speciality>;
  structure:Structure;
  constructor(private structureService : StructureService,
              private route: ActivatedRoute,
              private router:Router,
              private specialityService:SpecialityService) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];
    this.structureService.getSpecialityFromStructure(this.id,this.key).subscribe(
      data2=>{
        this.structureService.getStructure(this.id,this.key).subscribe(data => {
          this.structure=data;
          this.formGroup = new FormGroup({
            name: new FormControl(data.name),
            description: new FormControl(data.description),
            type: new FormControl(data.type),
            speciality: new FormControl(data2.name),
          });
          this.updateForm();
        });
      }
    );
    this.onGetSpeciality();
  }
  updateForm(){
    this.formGroup.patchValue({
      speciality : this.listSpecialities[this.findIndiceOfSpeciality(this.structure.speciality)],
    })
  }

  findIndiceOfSpeciality(speciality: Speciality) {
    for(let i = 0; i < this.listSpecialities.length; i++)
      if(this.listSpecialities[i].id == speciality.id)
        return i;
    return 0;
  }
  onGetSpeciality(){;
    console.log("get spéciality")
    this.specialityService
      .getSpecialities(this.key)
      .subscribe(
        data=>{this.listSpecialities=data;console.log("specialityyyyyyyy",data)},
        error => {console.log(error);
        })
  }
  onUpdateStructure() {
    let structure: Structure =  this.formGroup.value;
    structure.id = this.id;
    this.structureService.updateStructure(structure,this.key).subscribe(
      data => {this.updateStructure.emit(structure),
                     this.router.navigate(['/structures/'+this.key])},
      error => console.log(error)
    );}
}
