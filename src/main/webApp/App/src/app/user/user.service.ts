import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Profil} from "../model/profil";
type EntityResponseType = HttpResponse<Profil>;
@Injectable({
  providedIn: 'root'
})
export class StructureService {

  constructor(private httpClient:HttpClient) { }
  getProfil() : Observable<Array<Profil>> {
    return this.httpClient.get<Array<Profil>>('/profil');
  }
  deleteProfil(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Profil>('/profil/' + id, { observe: 'response' });
  }
  createProfil(structure:Profil): Observable<EntityResponseType> {
    return this.httpClient.post<Profil>('/profil', structure, { observe: 'response' });
  }
}
