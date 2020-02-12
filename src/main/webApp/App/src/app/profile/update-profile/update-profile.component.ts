import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Profile} from "../../model/profile";
import {ProfileService} from "../profile.service";

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  id:number;
  formGroup: FormGroup;
  @Output()
  updateProfile=new EventEmitter<Profile>();
  constructor(private profileService : ProfileService, private route: ActivatedRoute) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.profileService.getProfile(this.id).subscribe(data => {
      this.formGroup = new FormGroup({
        address: new FormControl(data.address),
        phoneNumber: new FormControl(data.phoneNumber),
        mail: new FormControl(data.mail),
        specialities: new FormControl(data.specialities)
      });
    });
  }
  onUpdateProfile() {
    let profile: Profile =  this.formGroup.value;
    profile.id = this.id;
    this.profileService.updateProfile(profile).subscribe(
      data => this.updateProfile.emit(profile),
      error => console.log(error)
    );}
}
