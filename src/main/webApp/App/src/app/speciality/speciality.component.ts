import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SpecialityService} from './speciality.service';
import {Speciality} from '../model/speciality';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-speciality',
  templateUrl: './speciality.component.html',
  styleUrls: ['./speciality.component.css']
})
export class SpecialityComponent implements OnInit {
  key:string;
  constructor(private specialityService:SpecialityService,private route:ActivatedRoute) { }
  listSpecialities:any;
  @Output()
  updateSpeciality= new EventEmitter<Speciality>();
  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.onGetStructures()
  }
  onGetStructures(){
    this.specialityService
      .getSpecialities(this.key)
      .subscribe(
        data=>{this.listSpecialities=data;},
        error => {console.log(error);
        })
  }

}
