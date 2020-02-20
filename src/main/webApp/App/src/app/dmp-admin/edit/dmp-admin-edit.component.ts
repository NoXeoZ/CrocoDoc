import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Dmp} from '../../model/dmp';
import {DmpAdminService} from '../dmp-admin.service';

@Component({
  selector: 'app-edit',
  templateUrl: './dmp-admin-edit.component.html',
  styleUrls: ['./dmp-admin-edit.component.css']
})
export class DmpAdminEditComponent implements OnInit {

  formGroup: FormGroup;

  @Output()
  createDmp= new EventEmitter<Dmp>();
  private key: string;

  constructor(private formBuilder: FormBuilder,
              private dmpAdminService:DmpAdminService,
              protected router: Router,
              private route:ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
    this.createForm();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'firstname': [null, Validators.required],
      'lastname': [null, Validators.required],
      'birth': [null, Validators.required],
      'birthCity': [null, Validators.required],
      'socialSecurityNumber': [null, Validators.required],
      'phoneNumber': [null, Validators.required],
      'email': [null, Validators.required],
    });
  }
  onCreateDmp(){
    this.dmpAdminService
      .createDmp(this.formGroup.value,this.key)
      .subscribe(
        data=>{this.createDmp.emit(this.formGroup.value);
          this.router.navigate(['/dmpAdmin/'+this.key])},
        error=>console.log(error)
      );
  }
  reset(){
    this.formGroup.reset();
  }
}
