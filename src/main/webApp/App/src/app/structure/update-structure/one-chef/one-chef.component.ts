import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from "../../../model/user";

@Component({
  selector: 'tr [chefStructure]',
  templateUrl: './one-chef.component.html',
  styleUrls: ['./one-chef.component.css']
})
export class StructureChefComponent implements OnInit {
  @Input()
  chefStructure: User;

  @Output()
  deleteChefInStructure = new EventEmitter<User>();
  constructor() { }

  ngOnInit() {
  }

  onDeleteChef(id: any) {
    this.deleteChefInStructure.emit(this.chefStructure);
  }


}
