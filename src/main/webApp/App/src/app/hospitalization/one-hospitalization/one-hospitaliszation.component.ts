import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HospitalizationService} from "../hospitalization.service";
import {Hospitalization} from "../../model/Hospitalization";

@Component({
  selector: 'tr [hospitalization]',
  templateUrl: './one-hospitalization.component.html',
  styleUrls: ['./one-hospitalization.component.css']
})
export class OneHospitalizationComponent implements OnInit {
  @Input()
  hospitalization: Hospitalization;
  private key: string;
  constructor(private hospitalizationService: HospitalizationService,private route :ActivatedRoute) { }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
  }

  displayAssignements() {
    let s = "[";
    let lst : Array<String> = [];



    for(let i = 0; i < this.hospitalization.assignments.length; i++){
      if(!this.contains(lst, this.hospitalization.assignments[i].service.name))
        lst.push(this.hospitalization.assignments[i].service.name)
    }
    for(let i = 0; i < lst.length; i++){
      s += lst[i];
      if(i < lst.length - 1)
        s += ", "
    }
    s += "]";
    if(s == "[]")
      s = "Aucun"
    return s;
  }


 contains(lst: Array<String>, name: string) {
    for(let i = 0; i < lst.length; i++){
      if(lst[i] == name){
        console.log("true")
        return true;

      }
    }
    console.log("false")
  return false;
}

  formatDate(nombre : number, chiffre : number) {
    var temp = '' + nombre;
    while ((temp.length < chiffre) && (temp = '0' + temp)) {}
    return temp;
  }

  printDate(d: Date) {

    let d2 = new Date(d);
    return "" + this.formatDate(d2.getDate(), 2) + "/" + this.formatDate(d2.getMonth()+1, 2) + "/" + this.formatDate(d2.getFullYear(), 4)+ '-> ' + this.formatDate(d2.getHours(), 2) + 'h' + this.formatDate(d2.getMinutes(), 2);

  }

}
