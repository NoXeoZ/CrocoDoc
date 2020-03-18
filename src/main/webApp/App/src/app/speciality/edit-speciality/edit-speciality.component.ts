import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Speciality} from '../../model/speciality';
import {SpecialityService} from '../speciality.service';

@Component({
  selector: 'app-edit-speciality',
  templateUrl: './edit-speciality.component.html',
  styleUrls: ['./edit-speciality.component.css']
})
export class EditSpecialityComponent implements OnInit {

  formGroup: FormGroup;
  key:string;
  @Output()
  createSpeciality= new EventEmitter<Speciality>();

  constructor(private formBuilder: FormBuilder,
              private specialityService:SpecialityService,
              protected router: Router,
              private route:ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.createForm();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'name': [null, Validators.required],
      'description': [null, Validators.required],
    });
  }
  onCreateSpeciality(){
    this.specialityService
      .createSpeciality(this.key,this.formGroup.value)
      .subscribe(
        data=>{this.createSpeciality.emit(this.formGroup.value);
          this.router.navigate(['/speciality/'+this.key])},
        error=>console.log(error)
      );
  }
  reset(){
    this.formGroup.reset();
  }
}
