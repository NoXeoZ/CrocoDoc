import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Structure} from "../model/structure";

type EntityResponseType = HttpResponse<Structure>;

@Injectable({
  providedIn: 'root'
})
export class StructureService {

  constructor(private httpClient:HttpClient) { }

  getStructures() : Observable<Array<Structure>> {
    return this.httpClient.get<Array<Structure>>('/structures');
  }

  getStructure(id: number) : Observable<Structure> {
    return this.httpClient.get<Structure>('/structures/' + id);
  }

  deleteStructure(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Structure>('/structures/' + id, { observe: 'response' });
  }
  createStructure(structure:Structure): Observable<EntityResponseType> {
    return this.httpClient.post<Structure>('/structures', structure, { observe: 'response' });
  }

  updateStructure(structure: Structure): Observable<EntityResponseType> {
    return this.httpClient.post<Structure>('/structures' + '/' + structure.id, structure, { observe: 'response' });
  }
}
