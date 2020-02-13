import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DmpAdminService} from './dmp-admin.service';
import {Dmp} from '../model/dmp';

@Component({
  selector: 'app-dmp-admin',
  templateUrl: './dmp-admin.component.html',
  styleUrls: ['./dmp-admin.component.css']
})
export class DmpAdminComponent implements OnInit {
  constructor(private dmpAdminService:DmpAdminService) { }
  listDmps:any;
  @Output()
  updateDmp = new EventEmitter<Dmp>();
  ngOnInit() {
    this.onGetDmps()
  }
  onGetDmps(){
    this.dmpAdminService
      .getDmps()
      .subscribe(
        data=>{this.listDmps=data;},
        error => {console.log(error);
        })
  }
}
