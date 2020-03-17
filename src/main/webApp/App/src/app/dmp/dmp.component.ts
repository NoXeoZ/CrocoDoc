import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {DmpService} from "./dmp.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Dmp} from "../model/dmp";
import {Hospitalization} from "../model/Hospitalization";
import {HospitalizationService} from "../hospitalization/hospitalization.service";

@Component({
  selector: 'app-dmp',
  templateUrl: './dmp.component.html',
  styleUrls: ['./dmp.component.css']
})
export class DmpComponent implements OnInit {
  @Input()
  private loginlist:Array<string>;
  @Output()
  private disconnectEvent=new EventEmitter<boolean>();

  formGroup:FormGroup;
  firstname='';
  key:string;
  lastname='';
  isDmp=false;
  isStructure=false;
  isSejour=false;
  dmpsSearch:Array<Dmp>;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  fullname='';
  private listHospitalization: Array<Hospitalization>;
  constructor(private breakpointObserver: BreakpointObserver,
              private formBuilder: FormBuilder,
              private dmpService:DmpService,
              private hospitalizationService:HospitalizationService,
              private router:Router) {}

  ngOnInit(): void {
    this.isDmp=true;
    this.key=this.loginlist[0];
    this.firstname=this.loginlist[1];
    this.lastname=this.loginlist[2];
    this.fullname=this.firstname+"   "+this.lastname;
    this.createForm()
  }
  createForm() {
    this.formGroup = this.formBuilder.group({
      'search': [null, Validators.required],
    });
  }


  desconnect() {
    console.log("dicon");
    this.dmpService
      .logOut(this.loginlist[0])
      .subscribe(
        data=>{this.disconnectEvent.emit(data);
        console.log("emiiiit event");
        },
        error=> {
          console.log(error);
        }
      );
  }

  searchDmp() {
    this.isDmp=true;
    this.isSejour=false;
    let name:string= this.formGroup.get('search').value;
    console.log(name)
    this.dmpService.
      getSearchDmp(this.key,name)
      .subscribe(
      data=>{console.log("get Dmp");
                   this.dmpsSearch=data;
                   console.log(data)
      },
      error=> {
        console.log(error);
      }
    );
  }

  getSejour($event: Dmp) {
    this.isSejour=true;
    this.isDmp=false;
    let dmp:Dmp=$event;
    console.log("get sejour of==>"+dmp);
      this.dmpService
        .getAllHospitalizationForDmp(this.key,dmp.id)
        .subscribe(
          data=>{this.listHospitalization=data;
            for (let h of this.listHospitalization){
                  h.dmp = dmp;
                  this.hospitalizationService.getHospitalOfHospitalization(this.key, h.id).subscribe(
                    data => {
                      h.hospital = data;
                      console.log(h);
                    })
            }},
          error => {console.log(error);
          })
    }
}
