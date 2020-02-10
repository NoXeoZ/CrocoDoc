import {Component, Input, OnInit} from '@angular/core';
import {Assignement} from '../../model/assignement';

@Component({
  selector: 'tr [assignement]',
  templateUrl: './one-assignement.component.html',
  styleUrls: ['./one-assignement.component.css']
})
export class OneAssignementComponent implements OnInit {

  @Input()
  assignement: Assignement;

  constructor() { }

  ngOnInit() {
  }

}
