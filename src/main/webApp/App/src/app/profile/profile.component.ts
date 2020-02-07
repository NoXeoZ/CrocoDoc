import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Structure} from "../model/structure";
import {StructureService} from "../structure/structure.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  formGroup: FormGroup;

  @Output()
  createStructure= new EventEmitter<Structure>();

  constructor(private formBuilder: FormBuilder,
              private structureService:StructureService,
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
    this.structureService
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


