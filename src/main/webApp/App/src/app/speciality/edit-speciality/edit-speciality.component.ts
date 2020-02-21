import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Speciality} from '../../model/speciality';
import {SpecialityService} from '../speciality.service';

@Component({
  selector: 'app-edit-speciality',
  templateUrl: './edit-speciality.component.html',
  styleUrls: ['./edit-speciality.component.css']
})
export class EditSpecialityComponent implements OnInit {

  formGroup: FormGroup;

  @Output()
  createSpeciality= new EventEmitter<Speciality>();

  constructor(private formBuilder: FormBuilder,
              private specialityService:SpecialityService,
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
  onCreateSpeciality(){
    this.specialityService
      .createSpeciality(this.formGroup.value)
      .subscribe(
        data=>{this.createSpeciality.emit(this.formGroup.value);
          this.router.navigate(['/speciality'])},
        error=>console.log(error)
      );
  }
  reset(){
    this.formGroup.reset();
  }
}
