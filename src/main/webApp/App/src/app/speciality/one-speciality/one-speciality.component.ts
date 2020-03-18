import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Speciality} from '../../model/speciality';

@Component({
  selector: 'tr [speciality]',
  templateUrl: './one-speciality.component.html',
  styleUrls: ['./one-speciality.component.css']
})
export class OneSpecialityComponent implements OnInit {

  @Input()
  speciality: Speciality;

  @Output()
  deleteSeciality = new EventEmitter<Speciality>();
  constructor() { }

  ngOnInit() {
  }
}
