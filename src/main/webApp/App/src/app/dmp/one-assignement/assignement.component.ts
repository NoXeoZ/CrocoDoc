import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Assignement} from "../../model/assignement";
import {Dmp} from "../../model/dmp";


@Component({
  selector: 'tr [assignement]',
  templateUrl: './assignement.component.html',
  styleUrls: ['./assignement.component.css']
})
export class AssignementComponent implements OnInit {
  @Input()
  assignement: Assignement;

  @Output()
  private assignementchoose=new EventEmitter<Assignement>();
  constructor() { }

  ngOnInit() {
  }


  assignementChoose(assignement: Assignement) {
    console.log("you choose =>",assignement);
    this.assignementchoose.emit(assignement);
  }
}
