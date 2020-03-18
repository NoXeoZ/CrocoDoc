import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Speciality} from '../model/speciality';
type EntityResponseType = HttpResponse<Speciality>;
@Injectable({
  providedIn: 'root'
})
export class SpecialityService {

  constructor(private httpClient:HttpClient) { }
  getSpecialities(key:string) : Observable<Array<Speciality>> {
    return this.httpClient.get<Array<Speciality>>('/specialities/'+key);
  }
  getSpeciality(key:string,id: number) : Observable<Speciality> {
    return this.httpClient.get<Speciality>('/specialities/'+key+'/' + id);
  }
  createSpeciality(key:string,structure:Speciality): Observable<EntityResponseType> {
    return this.httpClient.post<Speciality>('/specialities/'+key, structure, { observe: 'response' });
  }
  updateSpeciality(key:string,structure: Speciality): Observable<EntityResponseType> {
    return this.httpClient.post<Speciality>('/specialities/'+key +'/' + structure.id, structure, { observe: 'response' });
  }
}
