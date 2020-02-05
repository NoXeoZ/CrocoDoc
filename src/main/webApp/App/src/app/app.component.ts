import { Component } from '@angular/core';
import {Authetification} from "./model/authetification";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  isConnected = false;
  isAdmin=false;
  login='';
  password='';

  setIsConnected($event) {
    if ($event==1){
      this.isConnected=true;
    }else {
      this.isConnected=false;
    }
  }

  getAthentification($event: Authetification) {
    this.login=$event.login;
    this.password=$event.password;
    console.log(this.password)
    console.log(this.login)
  }
}
