import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StructureService} from "../structure.service";
import {User} from "../../model/user";

@Component({
  selector: 'app-dialog-overview',
  templateUrl: './dialog-chef.component.html',
  styleUrls: ['./dialog-chef.component.css']
})
export class DialogChefComponent implements OnInit {

  private formGroup: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private structureService:StructureService,
    private dialogRef: MatDialogRef<DialogChefComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Array<User>) {
    console.log(data);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.createForm();
  }
  createForm() {
    this.formGroup = this.formBuilder.group({
      'user': [null, Validators.required],
    });
  }

  doAction() {
    let id=this.formGroup.get("user").value;
    this.dialogRef.close({data:id});
    console.log("data envoyer"+id);
  }
}
