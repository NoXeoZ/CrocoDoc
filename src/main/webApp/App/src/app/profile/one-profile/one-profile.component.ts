import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Profile} from "../../model/profile";
import {ProfileService} from "../profile.service";

@Component({
  selector: 'tr [profile]',
  templateUrl: './one-profile.component.html',
  styleUrls: ['./one-profile.component.css']
})
export class OneProfileComponent implements OnInit {
  @Input()
  profile: Profile;

  @Output()
  deleteProfile = new EventEmitter<Profile>();
  constructor(private profileService: ProfileService) { }

  ngOnInit() {
  }
  onDeleteProfile(id: any){
    this.profileService
      .deleteProfile(this.profile.id)
      .subscribe(
        data=> this.deleteProfile.emit(this.profile),
        error => {console.log(error);
        })}
}
