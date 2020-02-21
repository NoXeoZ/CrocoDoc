import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProfileService} from "./profile.service";
import {Profile} from "../model/profile";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  constructor(private profileService:ProfileService) { }

  listProfiles : Array<Profile> = [{
    "id" : 1,
    "lastName": "Daniel",
    "firstName": "Randrianjatovo",
    "birthDate": new Date(),
    "address": "41 avenue andré malraux",
   "phoneNumber" : "0651712962",
    "mail": "d.randrianjatovo@gmail.com",
    "specialities": ["Rice","Vlad"]
  },
    {
      "id" : 1,
      "lastName": "Daniel",
      "firstName": "Randrianjatovo",
      "birthDate": new Date(),
      "address": "41 avenue andré malraux",
      "phoneNumber" : "0651712962",
      "mail": "d.randrianjatovo@gmail.com",
      "specialities": ["Rice","Vlad"]
    }];

  @Output()
  updateProfile = new EventEmitter<Profile>();
  ngOnInit() {
    this.onGetProfiles()
  }
  onGetProfiles(){
    this.profileService
      .getProfiles()
      .subscribe(
        data=>{this.listProfiles=data;},
        error => {console.log(error);
        })
  }
  refresh($event: any) {
    this.profileService.getProfiles().subscribe(
      data => this.listProfiles = data
    );}
}
