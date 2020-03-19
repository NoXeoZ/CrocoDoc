import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Profil} from "../../../model/profil";

@Component({
  selector: 'tr [chefStructure]',
  templateUrl: './one-chef.component.html',
  styleUrls: ['./one-chef.component.css']
})
export class StructureChefComponent implements OnInit {
  @Input()
  chefStructure: Profil;

  @Output()
  deleteChefInStructure = new EventEmitter<Profil>();
  constructor() { }

  ngOnInit() {
  }

  onDeleteChef(id: any) {
    this.deleteChefInStructure.emit(this.chefStructure);
  }


}
