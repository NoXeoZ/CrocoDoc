import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Structure} from '../../model/structure';


@Component({
  selector: 'app-dialog-overview',
  templateUrl: './dialog-overview-assignement.component.html',
  styleUrls: ['./dialog-overview-assignement.component.css']
})
export class DialogOverviewAssignementComponent implements OnInit {

  private formGroup: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<DialogOverviewAssignementComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Array<Structure>) {
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
      'startDate': [null, Validators.required],
      'endDate': [null, Validators.required],
      'structure': [null, Validators.required],

    });
  }

  doAction() {
    let assignement=this.formGroup.value;
    this.dialogRef.close({data:assignement});
    console.log("Assignement envoyer"+assignement);
  }
}
