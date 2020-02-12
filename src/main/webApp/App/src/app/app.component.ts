import { Component } from '@angular/core';
import {Authentification} from "./model/authentification";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  isConnected = false;
  isAdmin=false;
  loginlist:Array<string>;
  connectKey='';

  getAthentification($event: Array<string>) {
    this.loginlist=$event;
    this.connectKey=this.loginlist[0];
    if(this.connectKey!=null){
      this.isConnected=true;
      this.isAdmin=true;
    }else {
      this.isConnected=false;
    }
  }

  disconnect($event: boolean) {
    if($event==true){
      this.isConnected=false;
    }else {
      this.isConnected=false;
    }
  }
}
