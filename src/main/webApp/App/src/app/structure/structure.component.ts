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
  listStructures:Array<Structure>;
  key:string;
  @Output()
  updateStructure = new EventEmitter<Structure>();
  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.onGetStructures()
  }
  onGetStructures(){
    this.structureService
      .getStructures(this.key)
      .subscribe(
        data=>{this.listStructures=data,console.log("structure===>>>>",data);
          for(let i = 0; i < this.listStructures.length; i++){
            this.structureService.getParentFromStructure(this.listStructures[i].id, this.key).subscribe(
              data => {
                console.log(data);
                this.listStructures[i].parent = data
              }
            )}},
        error => {console.log(error);
        })
  }
}
