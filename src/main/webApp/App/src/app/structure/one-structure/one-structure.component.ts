import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Structure} from "../../model/structure";
import {StructureService} from "../structure.service";
import {ActivatedRoute} from "@angular/router";

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
  private key: string;
  constructor(private structureService: StructureService,private route :ActivatedRoute) { }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
  }
}
