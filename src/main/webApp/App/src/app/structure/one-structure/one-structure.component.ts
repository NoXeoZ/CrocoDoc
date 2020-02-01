import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Structure} from "../../model/structure";
import {StructureService} from "../structure.service";

@Component({
  selector: 'tr [structure]',
  templateUrl: './one-structure.component.html',
  styleUrls: ['./one-structure.component.css']
})
export class OneStructureComponent implements OnInit {
  @Input()
  structure: Structure;

  @Output()
  deleteStructure = new EventEmitter<Structure>();
  constructor(private structureService: StructureService) { }

  ngOnInit() {
  }

  onDeleteStructure(id: any){
    this.structureService
      .deleteStructure(this.structure.id)
      .subscribe(
        data=> this.deleteStructure.emit(this.structure),
        error => {console.log(error);
        })
  }

}
