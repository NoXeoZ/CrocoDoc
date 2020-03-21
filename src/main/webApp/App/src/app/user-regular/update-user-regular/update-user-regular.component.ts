import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TypeUser, User} from "../../model/user";
import {Structure} from "../../model/structure";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../user/user.service";
import {StructureService} from "../../structure/structure.service";

@Component({
  selector: 'app-update-user-regular',
  templateUrl: './update-user-regular.component.html',
  styleUrls: ['./update-user-regular.component.css']
})
export class UpdateUserRegularComponent implements OnInit {

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
    this.structureService.getStructures(this.key)
      .subscribe(s => {
        this.structures = s as Structure[]
      })

    this.userService.getUser(this.id, this.key).subscribe(data => {
      console.log(data.birthDate)
      let email1 = new FormControl(data.email, [
        Validators.required,
        Validators.email,
      ]);
      this.formGroup = new FormGroup({
        id: new FormControl(data.id),
        firstname: new FormControl(data.firstname),
        lastname: new FormControl(data.lastname),
        birthDate: new FormControl(new Date(data.birthDate).toISOString().substring(0,10)),
        address: new FormControl(data.address),
        email: new FormControl(data.email),
        phoneNumber: new FormControl(data.phoneNumber),
        rib: new FormControl(data.rib),
        password: new FormControl(data.password),
        structure: new FormControl(data.structure),
        type: new FormControl(data.type),
      });
    })
  }
  onUpdateUser() {
    let user: User =  this.formGroup.value;
    console.log("HEEEEEEEEEEEEEEEERRRRRRRRRRREEEEEEEEEEEEE")
    this.userService.createUser(user,this.key).subscribe(
      data => {this.updateUser.emit(user);
        this.router.navigate(['/user/' + this.key]).then(r  =>console.log("update Ok"))},
      error => console.log(error)
    );
    //}
  }

}
