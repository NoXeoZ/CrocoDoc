import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Act} from "../../model/Act";

@Component({
  selector: 'tr [act]',
  templateUrl: './one-act.component.html',
  styleUrls: ['./one-act.component.css']
})
export class OneActComponent implements OnInit {

  @Input()
  act: Act;

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

  getimage(image: any) {
    console.log("immmmmmmmmmmmmmmmmmaaaaaaage");
    console.log(image);
  }
}
