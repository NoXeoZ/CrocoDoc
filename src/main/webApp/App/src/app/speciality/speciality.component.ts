import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SpecialityService} from './speciality.service';
import {Speciality} from '../model/speciality';

@Component({
  selector: 'app-speciality',
  templateUrl: './speciality.component.html',
  styleUrls: ['./speciality.component.css']
})
export class SpecialityComponent implements OnInit {

  constructor(private specialityService:SpecialityService) { }
  listSpecialities:any;
  @Output()
  updateSpeciality= new EventEmitter<Speciality>();
  ngOnInit() {
    this.onGetStructures()
  }
  onGetStructures(){
    this.specialityService
      .getSpecialities()
      .subscribe(
        data=>{this.listSpecialities=data;},
        error => {console.log(error);
        })
  }
  refresh($event: any) {
    this.specialityService.getSpecialities().subscribe(
      data => this.listSpecialities = data
    );}

}
