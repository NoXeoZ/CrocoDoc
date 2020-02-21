import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ProfileService} from "../profile.service";
import {Profile} from "../../model/profile";

@Component({
  selector: 'app-profile',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  formGroup: FormGroup;

  @Output()
  createProfile= new EventEmitter<Profile>();

  constructor(private formBuilder: FormBuilder,
              private profileService:ProfileService,
              protected router: Router,
  ) {
  }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'lastName': [null, Validators.required],
      'firstName': [null, Validators.required],
      'birthDate': [null, Validators.required],
      'address': [null, Validators.required],
      'phoneNumber': [null, Validators.required],
    });
  }
  onCreateProfile(){
    this.profileService
      .createProfile(this.formGroup.value)
      .subscribe(
        data=>{this.createProfile.emit(this.formGroup.value);
          this.router.navigate(['/profiles'])},
        error=>console.log(error)
      );
  }
  reset(){
    this.formGroup.reset();
  }
}
