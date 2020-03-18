import {Component, Input, OnInit} from '@angular/core';
import {Assignement} from "../../model/assignement";


@Component({
  selector: 'tr [assignement]',
  templateUrl: './assignement.component.html',
  styleUrls: ['./assignement.component.css']
})
export class AssignementComponent implements OnInit {
  @Input()
  assignement: Assignement;

  constructor() { }

  ngOnInit() {
  }


  assignementChoose(assignement: Assignement) {
    console.log("you choose =>",assignement);
  }
}
