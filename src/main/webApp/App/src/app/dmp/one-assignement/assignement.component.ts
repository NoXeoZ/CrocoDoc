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

  constructor() { }

  ngOnInit() {
  }
}
