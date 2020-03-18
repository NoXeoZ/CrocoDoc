import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Dmp} from '../../model/dmp';
import {Act} from "../../model/Act";

@Component({
  selector: 'tr [act]',
  templateUrl: './one-act.component.html',
  styleUrls: ['./one-act.component.css']
})
export class OneActComponent implements OnInit {

  @Input()
  act: Act;
  @Output()
  private actchoose=new EventEmitter<Act>();

  constructor() { }

  ngOnInit() {
  }

  actChoose(act: Act) {
    console.log("you have choose ==>",act);
    this.actchoose.emit(act);
  }
}
