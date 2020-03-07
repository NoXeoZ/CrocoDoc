import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Hospitalization} from "../../model/Hospitalization";
import {HospitalizationService} from "../hospitalization.service";
import {Dmp} from "../../model/dmp";
import {DmpSecretaryService} from "../../dmp-admin/dmp-secretary.service";
import {StructureService} from "../../structure/structure.service";
import {Structure} from "../../model/structure";

@Component({
  selector: 'app-update-hospitalization',
  templateUrl: './update-hospitalization.component.html',
  styleUrls: ['./update-hospitalization.component.css']
})
export class UpdateHospitalizationComponent implements OnInit {
  id:number;
  dmps:Array<Dmp>;
  formGroup: FormGroup;
  @Output()
  updateHospitalization=new EventEmitter<Hospitalization>();
  private key: string;
  private listStructures: Array<Structure>;
  constructor(private hospitalizationService : HospitalizationService,
              private dmpAdminService:DmpSecretaryService,
              private route: ActivatedRoute,
              private structureService:StructureService) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];
    this.hospitalizationService.getHospitalization(this.id,this.key).subscribe(data => {
        this.formGroup = new FormGroup({
          dmp: new FormControl(data.dmp),
          hospital: new FormControl(data.hospital),
          startDate: new FormControl(data.startDate),
          endDate: new FormControl(data.endDate),
        });
      });
    this.onGetDmps();
    this.onGetStructures();
  }
  onGetDmps(){
    this.dmpAdminService
      .getDmps(this.key)
      .subscribe(
        data=>{this.dmps=data;},
        error => {console.log(error);
        })
  }
  onUpdateHospitalization() {
    let hospitalization: Hospitalization =  this.formGroup.value;
    hospitalization.id = this.id;
    this.hospitalizationService.updateHospitalization(hospitalization,this.key).subscribe(
      data => this.updateHospitalization.emit(hospitalization),
      error => console.log(error)
    );}
  onGetStructures(){
    this.structureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.listStructures=data,console.log(data)},
        error => {console.log(error);
        })
  }
}
