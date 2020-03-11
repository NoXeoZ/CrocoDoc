import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserService} from "./user.service";
import {User} from "../model/user";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  constructor(private userService:UserService,private route:ActivatedRoute) { }
  listUsers:any;
  key:string
  @Output()
  updateUser = new EventEmitter<User>();
  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.onGetUsers()
  }
  onGetUsers(){

    this.userService
      .getUsers(this.key)
      .subscribe(
        data=>{this.listUsers=data,console.log(data)},
        error => {console.log(error);
        })
  }
  refresh($event: any) {
    this.userService.getUsers(this.key).subscribe(
      data => this.listUsers = data
    );}

  add() {
    console.log("addddd");
  }
}
