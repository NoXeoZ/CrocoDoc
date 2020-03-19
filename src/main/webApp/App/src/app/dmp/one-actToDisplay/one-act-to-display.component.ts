import {Component, Input, OnInit} from '@angular/core';
import {Act} from "../../model/Act";
import {DmpService} from "../dmp.service";

@Component({
  selector: 'tr [actToDisplay]',
  templateUrl: './one-act-to-display.component.html',
  styleUrls: ['./one-act-to-display.component.css']
})
export class OneActToDisplayComponent implements OnInit {

  @Input()
  actToDisplay: Act;

  constructor(private dmpService : DmpService) { }

  ngOnInit() {
  }

  getStatus(draft: Boolean):string {
    let status:string;
    if(draft==true){
      status="Brouillon"
    }else {
      status="Valid"
    }
    return status;
  }

  text() {
    return this.actToDisplay.description;
  }

  displayAct() {
    let s = this.actToDisplay.type.toString();
    s += "\n\n\n\n\nDescription : " + this.actToDisplay.description;
    s += "\n\n\n\n\nFait le : " + (this.dateToString(this.actToDisplay.createdAt));
    s += "\n\nRédigé par : " + this.actToDisplay.user.firstname;
    return s;
  }

  formatDate(nombre : number, chiffre : number) {
    var temp = '' + nombre;
    while ((temp.length < chiffre) && (temp = '0' + temp)) {}
    return temp;
  }

  dateToString(d : Date){
    let d2 = new Date(d);
    return "" + this.formatDate(d2.getDate(), 2) + "/" + this.formatDate(d2.getMonth()+1, 2) + "/" + this.formatDate(d2.getFullYear(), 4)+ ' à ' + this.formatDate(d2.getHours(), 2) + 'h' + this.formatDate(d2.getMinutes(), 2);
  }

  return() {
    this.dmpService.sendHide();
  }
}
