import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Structure} from "../../model/structure";
import {StructureService} from "../structure.service";

@Component({
  selector: 'app-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
