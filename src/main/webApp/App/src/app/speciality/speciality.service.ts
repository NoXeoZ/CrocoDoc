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
  getSpecialities() : Observable<Array<Speciality>> {
    return this.httpClient.get<Array<Speciality>>('/speciality');
  }
  getSpeciality(id: number) : Observable<Speciality> {
    return this.httpClient.get<Speciality>('/speciality/' + id);
  }
  deleteSpeciality(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Speciality>('/speciality/' + id, { observe: 'response' });
  }
  createSpeciality(structure:Speciality): Observable<EntityResponseType> {
    return this.httpClient.post<Speciality>('/speciality', structure, { observe: 'response' });
  }
  updateSpeciality(structure: Speciality): Observable<EntityResponseType> {
    return this.httpClient.post<Speciality>('/speciality' + '/' + structure.id, structure, { observe: 'response' });
  }
}
