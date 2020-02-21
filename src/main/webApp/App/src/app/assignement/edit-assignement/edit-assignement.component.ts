import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Assignement} from '../../model/assignement';
import {AssignementService} from '../assignement.service';
import {StructureService} from '../../structure/structure.service';

@Component({
  selector: 'app-edit-assignement',
  templateUrl: './edit-assignement.component.html',
  styleUrls: ['./edit-assignement.component.css']
})
export class EditAssignementComponent implements OnInit {

  formGroup: FormGroup;

  @Output()
  createAssignement= new EventEmitter<Assignement>();
  services: any;
  private key: string;

  constructor(private formBuilder: FormBuilder,
              private assignementService:AssignementService,
              private structureService:StructureService,
              private route:ActivatedRoute,
              protected router: Router,

  ) {
  }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.createForm();
    this. onGetService();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'startDate': [null, Validators.required],
      'endDate': [null, Validators.required],
      'service':[null, Validators.required],

    });
  }
  onCreateAssignement(){
    console.log("on create");
    this.assignementService
      .createAssignement(this.formGroup.value)
      .subscribe(
        data=>{this.createAssignement.emit(this.formGroup.value);
        console.log(this.formGroup.value),
          this.router.navigate(['/assignement'])},
        error=>console.log(error)
      );
  }
  reset(){
    this.formGroup.reset();
  }
  onGetService(){
    this.structureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.services=data;console.log(data)},
        error => {console.log(error);
        })
  }
}
