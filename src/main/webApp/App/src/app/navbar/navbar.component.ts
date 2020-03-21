import {Component, EventEmitter, Input, Output} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {Router} from "@angular/router";
import {TypeUser} from "../model/user";
import {DmpService} from "../dmp/dmp.service";
import {UserRegularService} from "../user-regular/user-regular.service";

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
  private firstname: string;
  private lastname: string;

  constructor(private breakpointObserver: BreakpointObserver,private router:Router,private dmpService:DmpService) {
  }
  ngOnInit() {
    this.firstname=this.loginlistNav[1];
    this.lastname=this.loginlistNav[2];
    console.log(this.typeUser);
    if(this.typeUser==TypeUser.ADMIN){
      this.isAdmin=true;
      console.log(this.typeUser);
    }else if(this.typeUser==TypeUser.SECRETARY){
      this.isSecretary=true;
      console.log(this.typeUser);
    }
  }
  getDmp() {
    this.router.navigate(["/dmpSecretary/"+this.Key]);
  }

  desconnect() {
    this.dmpService
      .logOut(this.loginlistNav[0])
      .subscribe(
        data=>{
          setTimeout(() =>
            {
              window.location.replace("http://localhost:8080")
            },
            0);
          //this.disconnect.emit(data);
        },
        error=> {
          console.log(error);
        }
      );
  }
}
