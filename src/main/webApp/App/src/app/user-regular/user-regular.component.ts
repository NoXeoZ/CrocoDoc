import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from "../model/user";
import {UserService} from "../user/user.service";
import {ActivatedRoute} from "@angular/router";
import {FormControl, Validators} from "@angular/forms";
import {UserRegularService} from "./user-regular.service";

@Component({
  selector: 'app-user-regular',
  templateUrl: './user-regular.component.html',
  styleUrls: ['./user-regular.component.css']
})
export class UserRegularComponent implements OnInit {

  private id:any;
  private user: User;

  @Output()
  deleteUser = new EventEmitter<User>();
  private key: string;
  constructor(private userRegularService: UserRegularService,private route :ActivatedRoute) { }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.userRegularService.getId(this.key).subscribe(
      id =>  this.userRegularService.getUser(id,this.key).subscribe(data =>
      this.user = data,
        error => console.log("no key "+ this.key))
    )

  }


}
