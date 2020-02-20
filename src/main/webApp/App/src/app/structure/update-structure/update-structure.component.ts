import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Structure, StructureType} from "../../model/structure";
import {StructureService} from "../structure.service";

@Component({
  selector: 'app-update-structure',
  templateUrl: './update-structure.component.html',
  styleUrls: ['./update-structure.component.css']
})
export class UpdateStructureComponent implements OnInit {
  id:number;
  formGroup: FormGroup;
  type=[ StructureType.FUNCTIONAL_UNIT,StructureType.HOSPITAL,StructureType.POLE,StructureType.SERVICE,StructureType.HOSPITAL_UNIT];
  @Output()
  updateStructure=new EventEmitter<Structure>();
  private key: string;
  constructor(private structureService : StructureService, private route: ActivatedRoute) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.key = this.route.snapshot.params['key'];
    this.structureService.getStructure(this.id,this.key).subscribe(data => {
        this.formGroup = new FormGroup({
          name: new FormControl(data.name),
          description: new FormControl(data.description),
          type: new FormControl(data.type),
        });
      });
  }
  onUpdateStructure() {
    let structure: Structure =  this.formGroup.value;
    structure.id = this.id;
    this.structureService.updateStructure(structure,this.key).subscribe(
      data => this.updateStructure.emit(structure),
      error => console.log(error)
    );}
}
