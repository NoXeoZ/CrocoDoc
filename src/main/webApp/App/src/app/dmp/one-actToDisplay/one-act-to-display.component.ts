import {Component, Input, OnInit} from '@angular/core';
import {Act} from "../../model/Act";

@Component({
  selector: 'tr [actToDisplay]',
  templateUrl: './one-act-to-display.component.html',
  styleUrls: ['./one-act-to-display.component.css']
})
export class OneActToDisplayComponent implements OnInit {

  @Input()
  actToDisplay: Act;

  constructor() { }

  ngOnInit() {
  }

  getStatus(draft: Boolean):string {
    let status:string;
    if(draft==true){
      status="Brouillon"
    }else {
      status="Valid"
    }
    return status;
  }
}
