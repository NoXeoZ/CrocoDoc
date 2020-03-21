import {Component} from '@angular/core';
import {TypeUser} from "./model/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  isConnected = false;
  isAdmin=false;
  isLasStaff=false;
  isDOCTOR=false;
  isNurse=false;
  isSecretary=false;
  loginlist:Array<string>;
  connectKey='';
  typeUser='';

  getAthentification($event: Array<string>) {
    this.loginlist=$event;
    this.typeUser=this.loginlist[3]
    this.connectKey=this.loginlist[0];
    if(this.connectKey!=null){
      this.isConnected=true;
      this.setTypeUser(this.typeUser);
    }else {
      this.isConnected=false;
    }
  }
  setTypeUser(typeUser:string){
    if(typeUser==TypeUser.ADMIN){
      this.isAdmin=true;
    }else if(typeUser==TypeUser.DOCTOR){
      this.isDOCTOR=true;
    }else if(typeUser==TypeUser.NURSE){
      this.isNurse=true;
    } else if(typeUser==TypeUser.LAB_STAFF){
      this.isLasStaff=true;
    }else if(typeUser==TypeUser.SECRETARY){
      this.isSecretary=true;
    }
  }

  disconnect($event: boolean) {
    this.isAdmin=false;
    this.isLasStaff=false;
    this.isDOCTOR=false;
    this.isNurse=false;
    this.isSecretary=false;
    this.isConnected=false;
  }
}
