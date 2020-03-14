import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {DmpSecretaryService} from "../../dmp-admin/dmp-secretary.service";
import {HospitalizationService} from "../hospitalization.service";
import {Dmp} from "../../model/dmp";
import {Hospitalization} from "../../model/Hospitalization";
import {StructureService} from "../../structure/structure.service";
import {Structure} from "../../model/structure";

@Component({
  selector: 'app-hospitalization',
  templateUrl: './hospitalization-edit.component.html',
  styleUrls: ['./hospitalization-edit.component.css']
})
export class HospitalizationEditComponent implements OnInit {

  formGroup: FormGroup;

  @Output()
  createHospitalization= new EventEmitter<Hospitalization>();
  private key: string;
  private dmps: Array<Dmp>;
  private listStructures: Array<Structure>;

  constructor(private formBuilder: FormBuilder,
              private hospitalizationService:HospitalizationService,
              protected router: Router,
              private route:ActivatedRoute,
              private dmpAdminService:DmpSecretaryService,
              private structureService:StructureService
  ) {
  }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.createForm();
    this.onGetDmps();
    this.onGetStructures();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'dmp': [null, Validators.required],
      'hospital': [null, Validators.required],
      'startDate': [null, Validators.required],
      'endDate': [null, Validators.required],
      'heureDebut': [null, Validators.required],
      'heureFin': [null, Validators.required],
    });
  }
  onCreateHospitalization(){
    let hospitalization:Hospitalization=this.formGroup.value;
    let iDdmp=hospitalization.dmp.id;
    let idHopital=hospitalization.hospital.id;
    hospitalization.dmp=null;
    hospitalization.hospital=null;

    let start = new Date(hospitalization.startDate);
    let tab = this.formGroup.get('heureDebut').value.split(":");
    start.setHours(tab[0]);
    start.setMinutes(tab[1]);
    hospitalization.startDate = start;

    let end = new Date(hospitalization.endDate);
    tab = this.formGroup.get('heureFin').value.split(":");
    end.setHours(tab[0]);
    end.setMinutes(tab[1]);
    hospitalization.endDate = end;

    this.hospitalizationService
      .createHospitalization(hospitalization,this.key,iDdmp,idHopital)
      .subscribe(
        data=>{this.createHospitalization.emit(this.formGroup.value);console.log("data "+data.id);
          this.router.navigate(['/hospitalization/' + this.key]).then(r  =>console.log("create Ok"))},
        error=>console.log(error)
      );
  }
  onGetDmps(){
    this.dmpAdminService
      .getDmps(this.key)
      .subscribe(
        data=>{this.dmps=data;},
        error => {console.log(error);
        })
  }
  onGetStructures(){
    this.structureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.listStructures=data,console.log(data)},
        error => {console.log(error);
        })
  }

  reset(){
    this.formGroup.reset();
  }
}
