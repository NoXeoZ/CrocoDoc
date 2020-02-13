import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AssignementService} from './assignement.service';
import {Assignement} from '../model/assignement';

@Component({
  selector: 'app-assignement',
  templateUrl: './assignement.component.html',
  styleUrls: ['./assignement.component.css']
})
export class AssignementComponent implements OnInit {
  constructor(private assignementService:AssignementService) { }
  listAssignement:any;
  @Output()
  updateAssignement = new EventEmitter<Assignement>();
  ngOnInit() {
    this.onGetAssignement()
  }
  onGetAssignement(){
    this.assignementService
      .getAssignements()
      .subscribe(
        data=>{this.listAssignement=data;},
        error => {console.log(error);
        })
  }
}
