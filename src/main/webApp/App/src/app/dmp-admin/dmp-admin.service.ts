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
  getDmps(key:string) : Observable<Array<Dmp>> {
    return this.httpClient.get<Array<Dmp>>('/dmps/'+key);
  }
  getDmp(id: number) : Observable<Dmp> {
    return this.httpClient.get<Dmp>('/dmps/' + id);
  }
  createDmp(dmp:Dmp,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<Dmp>('/dmp/create/'+key, dmp, { observe: 'response' });
  }
}
