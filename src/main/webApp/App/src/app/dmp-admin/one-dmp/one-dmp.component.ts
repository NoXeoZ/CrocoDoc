import {Component, Input, OnInit} from '@angular/core';
import {Dmp} from '../../model/dmp';

@Component({
  selector: 'tr [dmp]',
  templateUrl: './one-dmp.component.html',
  styleUrls: ['./one-dmp.component.css']
})
export class OneDmpComponent implements OnInit {

  @Input()
  dmp: Dmp;

  constructor() { }

  ngOnInit() {
  }

}
