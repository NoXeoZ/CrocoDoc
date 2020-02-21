import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Structure} from "../model/structure"; // retire ça pour voir ce que tu dois changer
type EntityResponseType = HttpResponse<Structure>; // pareil

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
  deleteStructure(id: number,key:string): Observable<EntityResponseType> {
    return this.httpClient.delete<Structure>('/structures/'+key+'/' + id, { observe: 'response' });
  }
  createStructure(structure:Structure,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<Structure>('/structures/'+key, structure, { observe: 'response' });
  }
  updateStructure(structure: Structure,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<Structure>('/structures/' +key+ '/' + structure.id, structure, { observe: 'response' });
  }
}
