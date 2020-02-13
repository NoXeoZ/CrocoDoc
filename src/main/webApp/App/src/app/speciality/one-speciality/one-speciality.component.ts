import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Speciality} from '../../model/speciality';
import {SpecialityService} from '../speciality.service';

@Component({
  selector: 'tr [speciality]',
  templateUrl: './one-speciality.component.html',
  styleUrls: ['./one-speciality.component.css']
})
export class OneSpecialityComponent implements OnInit {

  @Input()
  speciality: Speciality;

  @Output()
  deleteSeciality = new EventEmitter<Speciality>();
  constructor(private specialityService: SpecialityService) { }

  ngOnInit() {
  }
  onDeleteSpeciality(id: any){
    this.specialityService
      .deleteSpeciality(this.speciality.id)
      .subscribe(
        data=> this.deleteSeciality.emit(this.speciality),
        error => {console.log(error);
        })}
}
