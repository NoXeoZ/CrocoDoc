import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Structure} from "../../model/structure";
import {StructureService} from "../structure.service";

@Component({
  selector: 'app-structure',
  templateUrl: './structure-edit.component.html',
  styleUrls: ['./structure-edit.component.css']
})
export class StructureEditComponent implements OnInit {

  formGroup: FormGroup;

  @Output()
  createStructure= new EventEmitter<Structure>();

  constructor(private formBuilder: FormBuilder,
              private strctureService:StructureService,
              protected router: Router,
  ) {
  }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'name': [null, Validators.required],
      'role': [null, Validators.required],
    });
  }
  onCreateStructure(){
    this.strctureService
      .createStructure(this.formGroup.value)
      .subscribe(
        data=>{this.createStructure.emit(this.formGroup.value);
          this.router.navigate(['/structures'])},
        error=>console.log(error)
      );
  }
  reset(){
    this.formGroup.reset();
  }
}
