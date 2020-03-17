import {Component, EventEmitter, Input, Output} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {Router} from "@angular/router";
import {TypeProfil} from "../model/profil";
import {DmpService} from "../dmp/dmp.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  @Input()
  private loginlistNav:Array<string>;
  @Input()
  Key:string;
  @Input()
  typeUser:any;

  @Output()
  private disconnect=new EventEmitter<boolean>();


  isAdmin=false;
  isSecretary=false

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,private router:Router,private dmpService:DmpService) {
  }
  ngOnInit() {
    console.log(this.typeUser);
    if(this.typeUser==TypeProfil.ADMIN){
      this.isAdmin=true;
      console.log(this.typeUser);
    }else if(this.typeUser==TypeProfil.SECRETARY){
      this.isSecretary=true;
      console.log(this.typeUser);
    }
  }
  getDmp() {
    this.router.navigate(["/dmpSecretary/"+this.Key]);
  }

  desconnect() {
    console.log("dicon");
    this.dmpService
      .logOut(this.loginlistNav[0])
      .subscribe(
        data=>{this.disconnect.emit(data);
          console.log("emiiiit event");
        },
        error=> {
          console.log(error);
        }
      );
  }
}
