import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {StructureService} from "./structure.service";
import {Structure} from "../model/structure";

@Component({
  selector: 'app-structure',
  templateUrl: './structure.component.html',
  styleUrls: ['./structure.component.css']
})
export class StructureComponent implements OnInit {
  constructor(private structureService:StructureService) { }
  listStructures:any;
  @Output()
  updateStructure = new EventEmitter<Structure>();
  ngOnInit() {
    this.onGetStructures()
  }
  onGetStructures(){
    this.structureService
      .getStructures()
      .subscribe(
        data=>{this.listStructures=data;},
        error => {console.log(error);
        })
  }
  refresh($event: any) {
    this.structureService.getStructures().subscribe(
      data => this.listStructures = data
    );}
}
