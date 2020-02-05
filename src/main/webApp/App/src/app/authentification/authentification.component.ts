import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthentificationService} from "./authentification.service";
import {Authetification} from "../model/authetification";

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {
  formGroup: FormGroup;
  @Output()
  token= new EventEmitter<number>();
  @Output()
  loginEvent=new EventEmitter<Authetification>();

  constructor(   private formBuilder: FormBuilder,
                 private authentificationService:AuthentificationService,
                 private router: Router) { }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      'login': [null, Validators.required],
      'password': [null, Validators.required],
    });
  }
  login() {
   /* this.authentificationService
      .logIn(this.formGroup.value)
      .subscribe(
        data=>{this.token.emit(1) ;
                      console.log("login data=>",data);
        },
        error=>console.log(error)
      );*/
    this.token.emit(1);
    this.loginEvent.emit(this.formGroup.value);
  }
}
