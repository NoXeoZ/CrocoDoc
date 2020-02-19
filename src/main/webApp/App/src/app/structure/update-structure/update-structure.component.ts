import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Structure} from "../../model/structure";
import {StructureService} from "../structure.service";

@Component({
  selector: 'app-update-structure',
  templateUrl: './update-structure.component.html',
  styleUrls: ['./update-structure.component.css']
})
export class UpdateStructureComponent implements OnInit {
  id:number;
  formGroup: FormGroup;
  @Output()
  updateStructure=new EventEmitter<Structure>();
  constructor(private structureService : StructureService, private route: ActivatedRoute) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.structureService.getStructure(this.id).subscribe(data => {
        this.formGroup = new FormGroup({
          name: new FormControl(data.name),
          description: new FormControl(data.description),
          type: new FormControl(data.type),
          parent: new FormControl(data.parent),
          chief: new FormControl(data.chief),
         // specialities: new FormControl(data.specialities),
        });
      });
  }
  onUpdateStructure() {
    let structure: Structure =  this.formGroup.value;
    structure.id = this.id;
    this.structureService.updateStructure(structure).subscribe(
      data => this.updateStructure.emit(structure),
      error => console.log(error)
    );}
}
