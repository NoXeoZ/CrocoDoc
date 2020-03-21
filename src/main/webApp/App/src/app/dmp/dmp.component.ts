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
import {Act} from "../model/Act";

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
  isAct=false;
  actToDsiplay:Act;
  dmpsSearch:Array<Dmp>;
  acts:Array<Act>;
  assignementId:number;
  listHospitalization: Array<Hospitalization>;
  listAssignement:Array<Assignement>;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  private hide: boolean = false;
  constructor(private breakpointObserver: BreakpointObserver,
              private formBuilder: FormBuilder,
              private dmpService:DmpService,
              private hospitalizationService:HospitalizationService,
              private router:Router) {}

  ngOnInit(): void {
    this.isDmp=true;
    this.hide = false;
    this.key=this.loginlist[0];
    this.firstname=this.loginlist[1];
    this.lastname=this.loginlist[2];
    this.idUser= +this.loginlist[4];
    console.log("ussssssssseeer===>",this.loginlist[4]);
    console.log("userrrrrrrrrrrrid===>",this.idUser);
    this.fullname=this.firstname+"   "+this.lastname;
    this.createForm();
    this.dmpService.event.subscribe(
      data => {
        this.dmpService.getActs(this.key,this.assignementId).subscribe(
          data3=> {
            this.acts = data3;
            console.log("act", data3);
            for (let i = 0; i < this.acts.length; i++) {
              this.dmpService.getUSerOfAct(this.key, this.acts[i].id).subscribe(
                data2 => this.acts[i].user = data2
              )
            }
            this.hide = false;

            this.isAssignement = true;
            this.isAct = false;
            console.log("here");

          },
          error => {console.log(error);
          }
        )


      }
    )
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
        data=>{
          setTimeout(() =>
            {
              window.location.replace("http://localhost:8080")
            },
            0);
          //this.disconnect.emit(data);
        },
        error=> {
          console.log(error);
        }
      );
  }

  searchDmp() {
    this.router.navigate(['/']);
    this.isDmp=true;
    this.isSejour=false;
    this.isStructure=false;
    this.isAssignement=false;
    this.hide=true;
    this.isAct=false;
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
    this.hide=false;
    this.dmpService.getActs(this.key,this.assignementId).subscribe(
      data=> {
        this.acts = data;
        console.log("get act==>", data);
        for (let i = 0; i < this.acts.length; i++) {
          this.dmpService.getUSerOfAct(this.key, this.acts[i].id).subscribe(
            data2 => this.acts[i].user = data2)}
      },
      error => {console.log(error);
      })
  }

  hideAssign() {
    this.hide = true;
  }


  displayAct(act: Act) {
     this.isAct=true;
    this.isAssignement=false;
    this.isStructure=false;
    this.isSejour=false;
    this.isDmp=false;
    this.hide=false;
    this.actToDsiplay=act;
    console.log("id",act.id);
    console.log("image=>",act.image);
  }
}
