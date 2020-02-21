import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Assignement} from '../model/assignement';
type EntityResponseType = HttpResponse<Assignement>;
@Injectable({
  providedIn: 'root'
})
export class AssignementService {

  constructor(private httpClient:HttpClient) { }
  getAssignements() : Observable<Array<Assignement>> {
    return this.httpClient.get<Array<Assignement>>('/affectations');
  }
  getAssignement(id: number) : Observable<Assignement> {
    return this.httpClient.get<Assignement>('/affectations/' + id);
  }
  deleteAssignement(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Assignement>('/affectations/' + id, { observe: 'response' });
  }
  createAssignement(assignement:Assignement): Observable<EntityResponseType> {
    return this.httpClient.post<Assignement>('/affectations', assignement, { observe: 'response' });
  }
  updateAssignement(assignement: Assignement): Observable<EntityResponseType> {
      return this.httpClient.post<Assignement>('/affectations' + '/' + assignement.id, assignement, { observe: 'response' });
  }
}
