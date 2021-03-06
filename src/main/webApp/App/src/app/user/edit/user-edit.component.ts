import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {TypeUser, User} from "../../model/user";
import {UserService} from "../user.service";
import {StructureService} from "../../structure/structure.service";
import {Observable} from "rxjs";
import {Structure} from "../../model/structure";

@Component({
  selector: 'app-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
  id:number;
  formGroup: FormGroup;
  types = [ TypeUser.SECRETARY,TypeUser.NURSE,TypeUser.DOCTOR,TypeUser.LAB_STAFF,TypeUser.ADMIN];

  @Output()
  createUser=new EventEmitter<User>();
  private key: string;
  hide = true;

  email1 = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);



  private structures:Structure[];

  constructor(private userService : UserService,
              private structureService : StructureService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              protected router: Router,) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];


    this.structureService.getStructures(this.key)
      .subscribe(countries => {
        this.structures = countries as Structure[]
      })

    this.createForm()
  }
  createForm() {
    this.formGroup = this.formBuilder.group({
      'firstname': [null, Validators.required],
      'lastname': [null, Validators.required],
      'birthDate': [null, Validators.required],
      'email': this.email1,
      'rib': [null, Validators.required],
      'type': [null,Validators.required],
      'structure': [null,Validators.required],
      //'structure': [null, Validators.required],
    });
  }
  /*onCreateUser() {
    let user: User =  this.formGroup.value;
    user.id = this.id;
    this.userService.createUser(user,this.key).subscribe(
      data => this.updateUser.emit(user),
      error => console.log(error)
    );
  }*/
  onCreateUser(){

    this.userService
      .createUser(this.formGroup.value,this.key)
      .subscribe(
        data=>{this.createUser.emit(this.formGroup.value);
          this.router.navigate(['/user/' + this.key]).then(r  =>console.log("create Ok"))},
        error=>console.log(error)
      );
  }




  /*
    createForm() {
      this.formGroup = this.formBuilder.group({
        'name': [null, Validators.required],
        'description': [null, Validators.required],
        'type': [null, Validators.required],
        //'parent': [null, Validators.required],
        //'chief': [null, Validators.required],
        //'specialities': [null, Validators.required],
    });
  }

  onCreateStructure(){
    this.strctureService
      .createStructure(this.formGroup.value,this.key)
      .subscribe(
        data=>{this.createStructure.emit(this.formGroup.value);
          this.router.navigate(['/structures/' + this.key]).then(r  =>console.log("create Ok"))},
        error=>console.log(error)
      );
  }*/


}
