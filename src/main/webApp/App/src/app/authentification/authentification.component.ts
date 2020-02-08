import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthentificationService} from "./authentification.service";
import {MatSnackBar} from '@angular/material';


@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {
  formGroup: FormGroup;
  @Output()
  loginEvent=new EventEmitter<Array<string>>();

  constructor(   private formBuilder: FormBuilder,
                 private authentificationService:AuthentificationService,
                 private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      'login': [null, Validators.required],
      'password': [null, Validators.required],
    });
  }
  login() {
    this.authentificationService
      .logIn(this.formGroup.value)
      .subscribe(
        data=> this.loginEvent.emit(data),
        error=> {
          this.snackBar.open("Wrong login or Password", "ok", {verticalPosition: 'top'});
        }
      );
  }
}
