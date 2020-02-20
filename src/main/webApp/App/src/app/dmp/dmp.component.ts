import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {DmpService} from "./dmp.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dmp',
  templateUrl: './dmp.component.html',
  styleUrls: ['./dmp.component.css']
})
export class DmpComponent implements OnInit {
  @Input()
  private loginlist:Array<string>;
  @Output()
  private disconnectEvent=new EventEmitter<boolean>()

  firstname='';
  lastname='';
  isDmp=false;
  isStructure=false;
  isSejour=false;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  fullname='';
  constructor(private breakpointObserver: BreakpointObserver,
              private dmpService:DmpService,
              private router:Router) {}

  ngOnInit(): void {
    this.isSejour=true;
    this.firstname=this.loginlist[1];
    this.lastname=this.loginlist[2];
    this.fullname=this.firstname+"   "+this.lastname;

  }


  desconnect() {
    this.dmpService
      .logOut(this.loginlist[0])
      .subscribe(
        data=>{this.disconnectEvent.emit(data)
        },
        error=> {
          console.log(error);
        }
      );
  }
}
