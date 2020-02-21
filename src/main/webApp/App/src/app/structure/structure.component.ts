import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {StructureService} from "./structure.service";
import {Structure} from "../model/structure";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-structure',
  templateUrl: './structure.component.html',
  styleUrls: ['./structure.component.css']
})
export class StructureComponent implements OnInit {
  constructor(private structureService:StructureService,private route:ActivatedRoute) { }
  listStructures:any;
  key:string
  @Output()
  updateStructure = new EventEmitter<Structure>();
  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    console.log("KEYYYYS 2"+this.key)
    this.onGetStructures()
  }
  onGetStructures(){
    this.structureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.listStructures=data,console.log(data)},
        error => {console.log(error);
        })
  }
  refresh($event: any) {
    this.structureService.getStructures(this.key).subscribe(
      data => this.listStructures = data
    );}

  add() {
    console.log("addddd");
  }
}
