import {Component, Input} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {Router} from "@angular/router";
import {TypeUser} from "../model/user";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  @Input()
  Key:string;
  @Input()
  typeUser:any;


  isAdmin=false;
  isSecretary=false

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,private router:Router) {
  }
  ngOnInit() {
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
}
