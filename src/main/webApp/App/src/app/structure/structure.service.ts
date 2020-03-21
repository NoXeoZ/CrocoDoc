import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Structure} from "../model/structure";
import {Speciality} from "../model/speciality";
import {User} from "../model/user";
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
  getParentFromStructure(id: number,key:string) : Observable<Structure> {
    return this.httpClient.get<Structure>('/structures/getParent/'+key+'/' + id);
  }
  getUsers(key: string) : Observable<Array<User>> {
    return this.httpClient.get<Array<User>>('/user/'+key);
  }
  affecteUser(key:string,idStructure: number,idUser:number) : Observable<Array<Structure>> {
    return this.httpClient.get<Array<Structure>>('/structures/'+ key+'/'+idStructure+'/'+idUser);
  }

  changeParent(key:string,idStructure: number,idParent:number) : Observable<Structure> {
    return this.httpClient.get<Structure>('/structures/changeParent/'+ key+'/'+idStructure+'/'+idParent);
  }

}
