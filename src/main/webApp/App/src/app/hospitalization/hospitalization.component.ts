import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HospitalizationService} from "./hospitalization.service";
import {Hospitalization} from "../model/Hospitalization";

@Component({
  selector: 'app-hospitalization',
  templateUrl: './hospitalization.component.html',
  styleUrls: ['./hospitalization.component.css']
})
export class HospitalizationComponent implements OnInit {
  constructor(private hospitalizationService:HospitalizationService,private route:ActivatedRoute) { }
  listHospitalization:Array<Hospitalization>=[];
  key:string
  @Output()
  updateHospitalization = new EventEmitter<Hospitalization>();
  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    console.log("hooooooopitalisation");
    this.onGetHospitalization();
  }
  onGetHospitalization(){
    this.hospitalizationService
      .getAllHospitalization(this.key)
      .subscribe(
        data=>{this.listHospitalization=data;
          for (let h of this.listHospitalization){
            console.log("hospid"+h.id);
            console.log("dmp"+h.dmp);
          }},
        error => {console.log(error);
        })
  }
  /*
  refresh($event: any) {
    this.hospitalizationService.getHospitalization(this.key).subscribe(
      data => this.listStructures = data
    );}*/

  add() {
    console.log("addddd");
  }
}
