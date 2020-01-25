import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {
  formGroup: FormGroup;

  constructor(   private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    let emailregex: RegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    this.formGroup = this.formBuilder.group({
      'username': [null, Validators.required, Validators.pattern(emailregex)],
      'password': [null, Validators.required],
    });
  }
  getErrorlogin() {
    return this.formGroup.get('username').hasError('required') ? 'Field is required' :
      this.formGroup.get('username').hasError('pattern') ? 'Not a valid emailaddress' : '';
  }
  getErrorPassord(){
    return this.formGroup.get('password').hasError('required') ? 'Field is required' : '';
  }
  login() {
    console.log('Tentative de connexion');
  }
}
