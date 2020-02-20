import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Dmp} from '../../model/dmp';
import {DmpSecretaryService} from '../dmp-secretary.service';

@Component({
  selector: 'app-edit',
  templateUrl: './dmp-secretary-edit.component.html',
  styleUrls: ['./dmp-secretary-edit.component.css']
})
export class DmpSecretaryEditComponent implements OnInit {

  formGroup: FormGroup;

  @Output()
  createDmp= new EventEmitter<Dmp>();
  private key: string;

  constructor(private formBuilder: FormBuilder,
              private dmpAdminService:DmpSecretaryService,
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
          this.router.navigate(['/dmpSecretary/'+this.key])},
        error=>console.log(error)
      );
  }
  reset(){
    this.formGroup.reset();
  }
}
