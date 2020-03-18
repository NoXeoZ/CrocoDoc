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
import {Assignement} from "../model/assignement";

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
  fullname='';
  isDmp=false;
  isStructure=false;
  isSejour=false;
  isAssignement=false;
  idUser:number;

  dmpsSearch:Array<Dmp>;
  assignementId:number;
  listHospitalization: Array<Hospitalization>;
  listAssignement:Array<Assignement>;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
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
    this.idUser= +this.loginlist[4];
    console.log("ussssssssseeer===>",this.loginlist[4]);
    console.log("userrrrrrrrrrrrid===>",this.idUser);
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
    this.isStructure=false;
    this.isAssignement=false;
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

  getAssignement($event: Array<Assignement>) {
    this.isStructure=true;
    this.isSejour=false;
    this.isDmp=false;
    this.isAssignement=false;
    this.listAssignement=$event;
  }

  getActOfAssignement($event: Assignement) {
    let assignement:Assignement=$event;
    this.assignementId=assignement.id;
    this.isAssignement=true;
    this.isStructure=false;
    this.isSejour=false;
    this.isDmp=false;
    console.log("idUser=>",this.idUser)
    console.log("idAssignement=>",this.assignementId)
  }
}
