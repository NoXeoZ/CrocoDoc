import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hospitalization} from "../model/Hospitalization";
import {Dmp} from "../model/dmp";
import {Structure} from "../model/structure";
import {Assignement} from '../model/assignement';

type EntityResponseType = HttpResponse<Hospitalization>;
@Injectable({
  providedIn: 'root'
})
export class HospitalizationService {

  constructor(private httpClient:HttpClient) { }

  getAllHospitalizationForDMP(key: string,idDmp:number) : Observable<Array<Hospitalization>> {
    return this.httpClient.get<Array<Hospitalization>>('/dmp/hospitalization/'+key+'/'+idDmp);
  }
  getHospitalization(id: number,key:string) : Observable<Hospitalization> {
    return this.httpClient.get<Hospitalization>('/dmp/hospitalization/'+key+'/' + id);
  }
  getAllHospitalization(key:string) : Observable<Array<Hospitalization>> {
    return this.httpClient.get<Array<Hospitalization>>('/dmp/hospitalization/'+key);
  }
  getDmpOfHospitalization(key:string, idHospitalization: number) : Observable<Dmp> {
    return this.httpClient.get<Dmp>('/dmp/hospitalizationDMP/' + key + '/' + idHospitalization);
  }
  getHospitalOfHospitalization(key:string, idHospitalization: number) : Observable<Structure> {
    return this.httpClient.get<Structure>('/dmp/hospitalizationStruct/' + key + '/' + idHospitalization);
  }
  createHospitalization(hospitalization:Hospitalization, key:string,idDmp:number,idHopital:number):Observable<Hospitalization>{
    return this.httpClient.post<Hospitalization>('/dmp/hospitalization/create/'+key+'/'+idDmp+'/'+idHopital, hospitalization );
  }
  updateHospitalization(hospitalization: Hospitalization, key:string): Observable<EntityResponseType> {
    return this.httpClient.post<Hospitalization>('/dmp/hospitalization/update/' +key, hospitalization, { observe: 'response' });
  }

  createAssignement(key: string, assignement: Assignement) : Observable<EntityResponseType>{
    return this.httpClient.post<EntityResponseType>('/dmp/hospitalization/assignment/create/'+ key,assignement);
  }

}
