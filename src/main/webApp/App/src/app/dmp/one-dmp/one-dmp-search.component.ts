import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Dmp} from '../../model/dmp';

@Component({
  selector: 'tr [dmpSearch]',
  templateUrl: './one-dmp-search.component.html',
  styleUrls: ['./one-dmp-search.component.css']
})
export class OneDmpSearchComponent implements OnInit {

  @Input()
  dmpSearch: Dmp;
  @Output()
  private dmpchoose=new EventEmitter<Dmp>();

  constructor() { }

  ngOnInit() {
  }

  dmpChoose(dmpSearch: Dmp) {
    console.log("you have choose ==>",dmpSearch);
    this.dmpchoose.emit(dmpSearch);
  }
}
