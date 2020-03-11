import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {User, TypeUser} from "../../model/user";
import {UserService} from "../user.service";
import {ErrorStateMatcher} from "@angular/material/core";


@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  id:number;
  formGroup: FormGroup;
  type=[ TypeUser.SECRETARY,TypeUser.NURSE,TypeUser.DOCTOR,TypeUser.LAB_STAFF,TypeUser.ADMIN];

  startDate = new Date(1970, 0, 1);

  @Output()
  updateUser=new EventEmitter<User>();
  private key: string;
  hide = true;

  email1 = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  constructor(private userService : UserService, private route: ActivatedRoute) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];
    this.userService.getUser(this.id,this.key).subscribe(data => {
        this.formGroup = new FormGroup({
          id: new FormControl(data.id),
          firstName: new FormControl(data.firstname),
          lastName: new FormControl(data.lastname),
          birthDate: new FormControl(data.birthDate),
          address: new FormControl(data.address),
          phoneNumber: new FormControl(data.phoneNumber),
          email: this.email1,
          //password: new FormControl(data.password),
          RIB: new FormControl(data.RIB),
          structure: new FormControl(data.structure),
          //specialities : new FormControl(data.specialities)
        });
      });
  }
  onUpdateUser() {
    let user: User =  this.formGroup.value;
    user.id = this.id;
    /*if(user.type == TypeUser.ADMIN){
      this.userService.updateUserForAdmin(user,this.key).subscribe(
            data => this.updateUser.emit(user),
            error => console.log(error)
          );}
    }else{*/
      this.userService.updateUser(user,this.key).subscribe(
        data => this.updateUser.emit(user),
        error => console.log(error)
      );
      //}
    }
}
