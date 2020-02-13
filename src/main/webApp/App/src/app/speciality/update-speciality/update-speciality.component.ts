import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {Speciality} from '../../model/speciality';
import {SpecialityService} from '../speciality.service';

@Component({
  selector: 'app-update-speciality',
  templateUrl: './update-speciality.component.html',
  styleUrls: ['./update-speciality.component.css']
})
export class UpdateSpecialityComponent implements OnInit {

  id:number;
  formGroup: FormGroup;
  @Output()
  updateSpeciality=new EventEmitter<Speciality>();
  constructor(private specialityService : SpecialityService, private route: ActivatedRoute) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.specialityService.getSpeciality(this.id).subscribe(data => {
      this.formGroup = new FormGroup({
        name: new FormControl(data.name),
        description: new FormControl(data.description),
      });
    });
  }
  onUpdateSpeciality() {
    let speciality: Speciality =  this.formGroup.value;
    speciality.id = this.id;
    this.specialityService.updateSpeciality(speciality).subscribe(
      data => this.updateSpeciality.emit(speciality),
      error => console.log(error)
    );}
}
