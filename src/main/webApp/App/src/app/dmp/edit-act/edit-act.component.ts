import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Hospitalization} from "../../model/Hospitalization";
import {ActivatedRoute, Router} from "@angular/router";
import {Assignement} from "../../model/assignement";
import {DmpService} from "../dmp.service";
import {Act, ActType} from "../../model/Act";

@Component({
  selector: 'app-edit-act',
  templateUrl: './edit-act.component.html',
  styleUrls: ['./edit-act.component.css']
})
export class EditActComponent implements OnInit {
  @Input() file: any;
  formGroup: FormGroup;
  type=[ActType.CONSTANT_REPORT,ActType.EXAM,ActType.PRESCRIPTION,ActType.OBSERVATION];
  @Output()
  createHospitalization= new EventEmitter<Hospitalization>();
  key: string;
  assignementId:number;
  assignement: Assignement;
  idUser: number;

  fileUpload: any;

  constructor(private formBuilder: FormBuilder,
              private dmpService:DmpService,
              protected router: Router,
              private route:ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.assignementId = this.route.snapshot.params['assignementId'];
    this.idUser = this.route.snapshot.params['idUser'];
    this.dmpService.getAssignement(this.key,this.assignementId)
      .subscribe(
        data=>{this.assignement=data},
        error=>console.log(error)
      );
    this.createForm();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'description': [null, Validators.required],
      'createdAt': [null, Validators.required],
      'draft': [null, Validators.required],
      'type': [null, Validators.required],
      'heureCreated': [null, Validators.required],
    });
  }
  onCreateAct(){
    let act:Act=this.formGroup.value;
    act.assignment=null;
    act.user=null;

    act.images = this.fileUpload[0].preview;

    let start = new Date(act.createdAt);
    let tab = this.formGroup.get('heureCreated').value.split(":");
    start.setHours(tab[0]);
    start.setMinutes(tab[1]);
    act.createdAt = start;

    this.dmpService
      .createAct(this.key,act,this.assignementId,this.idUser)
      .subscribe(
        data=>{console.log("data "+data.id);
          this.dmpService.sendHide();
          this.router.navigate(['/']).then(r  =>console.log("create Ok"))},
        error=>console.log(error)
      );
  }

  uploadDocument() {
    console.log("file upload");
    const fileReader = new FileReader();
    fileReader.onload = (e) => {
      if (typeof fileReader.result === 'string') {
           console.log("file upload ===>",fileReader);
      }
    };
  }
  fileChanged(e) {
    console.log("filchanged");
    this.file = e.target.files[0];
    console.log("filchanged==>",this.file);
  }

}
