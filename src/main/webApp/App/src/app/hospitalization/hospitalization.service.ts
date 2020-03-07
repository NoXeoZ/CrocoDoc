import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hospitalization} from "../model/Hospitalization";

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

  createHospitalization(hospitalization:Hospitalization, key:string,idDmp:number,idHopital:number):Observable<Hospitalization>{
    return this.httpClient.post<Hospitalization>('/dmp/hospitalization/create/'+key+'/'+idDmp+'/'+idHopital, hospitalization );
  }
  updateHospitalization(hospitalization: Hospitalization, key:string): Observable<EntityResponseType> {
    return this.httpClient.post<Hospitalization>('/dmp/hospitalization/update/' +key, hospitalization, { observe: 'response' });
  }
}
