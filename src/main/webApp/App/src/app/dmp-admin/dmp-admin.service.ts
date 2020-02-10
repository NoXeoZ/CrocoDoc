import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Dmp} from '../model/dmp';

type EntityResponseType = HttpResponse<Dmp>;
@Injectable({
  providedIn: 'root'
})
export class DmpAdminService {

  constructor(private httpClient:HttpClient) { }
  getDmps() : Observable<Array<Dmp>> {
    return this.httpClient.get<Array<Dmp>>('/dmps');
  }
  getDmp(id: number) : Observable<Dmp> {
    return this.httpClient.get<Dmp>('/dmps/' + id);
  }
  createDmp(dmp:Dmp): Observable<EntityResponseType> {
    return this.httpClient.post<Dmp>('/dmps', dmp, { observe: 'response' });
  }
}
