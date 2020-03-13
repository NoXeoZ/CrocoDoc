import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Structure} from '../../model/structure';
import {Assignement} from '../../model/assignement';


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
      'heureDebut': [null, Validators.required],
      'heureFin': [null, Validators.required],

    });
  }

  doAction() {
    let assignement:Assignement=this.formGroup.value;

    let start = new Date(assignement.startDate);
    let tab = this.formGroup.get('heureDebut').value.split(":");
    start.setHours(tab[0]);
    start.setMinutes(tab[1]);
    assignement.startDate = start;

    let end = new Date(assignement.endDate);
    tab = this.formGroup.get('heureFin').value.split(":");
    end.setHours(tab[0]);
    end.setMinutes(tab[1]);
    assignement.endDate = end;

    console.log("formmmm=++++>",assignement.startDate);
    this.dialogRef.close({data:assignement});
    console.log("Assignement envoyer service =++>",assignement.service);
  }
}
