import {Component, Input, OnInit} from '@angular/core';
import {Assignement} from '../../../model/assignement';

@Component({
  selector: 'tr [assignementHospitalization]',
  templateUrl: './assignement-of-hospitalization.component.html',
  styleUrls: ['./assignement-of-hospitalization.component.css']
})
export class AssignementHospitalizationComponent implements OnInit {
  @Input()
  assignementHospitalization: Assignement;

  constructor() { }

  ngOnInit() {
  }




}
