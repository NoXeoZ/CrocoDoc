import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Structure} from "../model/structure";
import {Speciality} from "../model/speciality";
import {Profil} from "../model/profil";
type EntityResponseType = HttpResponse<Structure>;
@Injectable({
  providedIn: 'root'
})
export class StructureService {

  constructor(private httpClient:HttpClient) { }

  getStructures(key: string) : Observable<Array<Structure>> {
    return this.httpClient.get<Array<Structure>>('/structures/'+key);
  }
  getStructure(id: number,key:string) : Observable<Structure> {
    return this.httpClient.get<Structure>('/structures/'+key+'/' + id);
  }
  createStructure(structure:Structure,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<Structure>('/structures/'+key, structure, { observe: 'response' });
  }
  updateStructure(structure: Structure,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<Structure>('/structures/' +key+ '/' + structure.id, structure, { observe: 'response' });
  }
  getSpecialityFromStructure(id: number,key:string) : Observable<Speciality> {
    return this.httpClient.get<Speciality>('/structures/getSpeciality/'+key+'/' + id);
  }
  getProfils(key: string) : Observable<Array<Profil>> {
    return this.httpClient.get<Array<Profil>>('/user/'+key);
  }
  affecteProfil(key:string,idStructure: number,idProfil:number) : Observable<Array<Structure>> {
    return this.httpClient.get<Array<Structure>>('/structures/'+ key+'/'+idStructure+'/'+idProfil);
  }

}
