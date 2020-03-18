import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {User, TypeUser} from "../../model/user";
import {UserService} from "../user.service";
import {ErrorStateMatcher} from "@angular/material/core";
import {Structure} from "../../model/structure";
import {StructureService} from "../../structure/structure.service";


@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  id:number;
  formGroup: FormGroup;
  types =[ TypeUser.SECRETARY,TypeUser.NURSE,TypeUser.DOCTOR,TypeUser.LAB_STAFF,TypeUser.ADMIN];

  startDate = new Date(1970, 0, 1);



  @Output()
  updateUser=new EventEmitter<User>();
  private key: string;
  hide = true;

  email1 = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  private structures:Structure[];

  constructor(protected router: Router,private userService : UserService, private route: ActivatedRoute,private structureService : StructureService) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];
    this.userService.getUser(this.id,this.key)
      .subscribe(data => {
        if (data.type == TypeUser.SECRETARY) {
          console.log("DOPEEE")
          this.structureService.getStructures(this.key)
            .subscribe(s => {
              this.structures = s as Structure[]
            })

          this.userService.getUser(this.id, this.key).subscribe(data => {
            let email1 = new FormControl(data.email, [
              Validators.required,
              Validators.email,
            ]);
            this.formGroup = new FormGroup({
              id: new FormControl(data.id),
              firstname: new FormControl(data.firstname),
              lastname: new FormControl(data.lastname),
              birthDate: new FormControl(new Date(data.birthDate)),
              email: email1,
              rib: new FormControl(data.RIB),
              structure: new FormControl(data.structure),
              type: new FormControl(data.type),
            });
          });
        }else{

        }


      })


  }
  onUpdateUser() {
    let user: User =  this.formGroup.value;
    /*if(user.type == TypeUser.ADMIN){
      this.userService.updateUserForAdmin(user,this.key).subscribe(
            data => this.updateUser.emit(user),
            error => console.log(error)
          );}
    }else{*/
    console.log("HEEEEEEEEEEEEEEEERRRRRRRRRRREEEEEEEEEEEEE")
      this.userService.createUser(user,this.key).subscribe(
        data => {this.updateUser.emit(user);
    this.router.navigate(['/user/' + this.key]).then(r  =>console.log("update Ok"))},
        error => console.log(error)
      );
      //}
    }
}
