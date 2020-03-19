import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Structure, StructureType} from "../../model/structure";
import {StructureService} from "../structure.service";
import {Speciality} from "../../model/speciality";
import {SpecialityService} from "../../speciality/speciality.service";

@Component({
  selector: 'app-structure',
  templateUrl: './structure-edit.component.html',
  styleUrls: ['./structure-edit.component.css']
})
export class StructureEditComponent implements OnInit {

  formGroup: FormGroup;
  type=[ StructureType.FUNCTIONAL_UNIT,StructureType.HOSPITAL,StructureType.POLE,StructureType.SERVICE,StructureType.HOSPITAL_UNIT];

  @Output()
  createStructure= new EventEmitter<Structure>();
  key: string;
  listSpecialities: Array<Speciality>;
  listStructures: Array<Structure>;

  constructor(private formBuilder: FormBuilder,
              private strctureService:StructureService,
              protected router: Router,
              protected specialityService:SpecialityService,
              private route:ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.createForm();
    this.onGetSpeciality();
    this.onGetStructures();
  }
  onGetSpeciality(){
    this.specialityService
      .getSpecialities(this.key)
      .subscribe(
        data=>{this.listSpecialities=data;},
        error => {console.log(error);
        })
  }

  onGetStructures(){
    this.strctureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.listStructures=data;},
        error => {console.log(error);
        })
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'name': [null, Validators.required],
      'description': [null, Validators.required],
      'type': [null, Validators.required],
      'speciality': [null, Validators.required],
      'parent': [null, Validators.required],
      /*'chief': [null, Validators.required],*/
    });
  }
  onCreateStructure(){
    this.strctureService
      .createStructure(this.formGroup.value,this.key)
      .subscribe(
        data=> {
          this.createStructure.emit(this.formGroup.value);
          console.log(data)
          this.strctureService.changeParent(this.key, data.body.id, this.formGroup.get("parent").value.id).subscribe(
            data2 => {
              this.router.navigate(['/structures/' + this.key]).then(r => console.log("create Ok"))

            }
          )
        },
        error=>console.log(error)
      );
  }

  reset(){
    this.formGroup.reset();
  }
}
