import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Profile} from "../../model/profile";
import {ProfileService} from "../profile.service";

@Component({
  selector: 'app-one-profile-large',
  templateUrl: './one-profile-large.component.html',
  styleUrls: ['./one-profile-large.component.css']
})
export class OneProfileLargeComponent implements OnInit {

  constructor(private profileService:ProfileService) { }
  profile : Profile = {
    "id" : 1,
    "lastName": "Daniel",
    "firstName": "Randrianjatovo",
    "birthDate": new Date(),
    "address": "41 avenue andré malraux",
    "phoneNumber" : "0651712962",
    "mail": "d.randrianjatovo@gmail.com",
    "specialities": ["Rice","Vlad"]
  };

  @Output()
  updateProfile = new EventEmitter<Profile>();

  ngOnInit() {
    this.onGetProfile(this.profile.id);
  }

  onGetProfile(id:any){
    this.profileService
      .getProfile(this.profile.id)
      .subscribe(
        data=>{this.profile=data;},
        error => {console.log(error);
        })
  }
  refresh($event: any,id:any) {
    this.profileService.getProfile(id).subscribe(
      data => this.profile= data
    );}

}
