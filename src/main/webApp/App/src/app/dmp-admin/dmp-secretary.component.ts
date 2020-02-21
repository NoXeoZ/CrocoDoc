import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DmpSecretaryService} from './dmp-secretary.service';
import {Dmp} from '../model/dmp';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-dmp-admin',
  templateUrl: './dmp-secretary.component.html',
  styleUrls: ['./dmp-secretary.component.css']
})
export class DmpSecretaryComponent implements OnInit {
  constructor(private dmpAdminService:DmpSecretaryService, private route:ActivatedRoute) { }
  listDmps:any;
  key:string
  @Output()
  updateDmp = new EventEmitter<Dmp>();
  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    console.log(this.key);
    this.onGetDmps()
  }
  onGetDmps(){
    this.dmpAdminService
      .getDmps(this.key)
      .subscribe(
        data=>{this.listDmps=data;},
        error => {console.log(error);
        })
  }
}
