import {HttpClient} from "@angular/common/http";
import {EventEmitter, Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Hospitalization} from "../model/Hospitalization";
import {Dmp} from "../model/dmp";
import {Assignement} from "../model/assignement";
import {Act} from "../model/Act";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class DmpService {

  event = new EventEmitter();

  constructor(private httpClient:HttpClient) { }

  logOut(key:String) : Observable<boolean> {
    return this.httpClient.get<boolean>('/disconnect'+'/'+key);
  }
  getSearchDmp(key:string,name:string) : Observable<Array<Dmp>> {
    return this.httpClient.get<Array<Dmp>>('/dmp/search/'+key+'/'+name);
  }
  getAllHospitalizationForDmp(key:string,id:number) : Observable<Array<Hospitalization>> {
    return this.httpClient.get<Array<Hospitalization>>('/dmp/hospitalizations/'+key+'/'+id);
  }
  getAssignement(key:string,assignementId:number) : Observable<Assignement> {
    return this.httpClient.get<Assignement>('/dmp/hospitalization/assignment/'+key+'/'+assignementId);
  }
  createAct(key: string, act: Act,idAssignement:number,idUser:number) : Observable<Act>{
    return this.httpClient.post<Act>('/dmp/hospitalization/assignment/act/create/'+ key+'/'+idAssignement+'/'+idUser,act);
  }
  getActs(key:string,assignementId:number) : Observable<Array<Act>> {
    return this.httpClient.get<Array<Act>>('/dmp/hospitalization/assignment/acts/'+key+'/'+assignementId);
  }

  getUSerOfAct(key:string,actId:number) : Observable<User> {
    return this.httpClient.get<User>('/dmp/hospitalization/assignment/act/user/'+key+'/'+actId);
  }

  sendHide() {
    this.event.emit(1);
  }
}
