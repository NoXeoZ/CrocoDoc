import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Hospitalization} from "../model/Hospitalization";
import {Dmp} from "../model/dmp";

@Injectable({
  providedIn: 'root'
})
export class DmpService {
  constructor(private httpClient:HttpClient) { }

  logOut(key:String) : Observable<boolean> {
    return this.httpClient.get<boolean>('/disconnect'+'/'+key);
  }
  getSearchDmp(key:string,name:string) : Observable<Array<Dmp>> {
    return this.httpClient.get<Array<Dmp>>('/dmp/search/'+key+'/'+name);
  }
  getAllHospitalizationForDmp(key:string,id:number) : Observable<Array<Hospitalization>> {
    return this.httpClient.get<Array<Hospitalization>>('/dmp/hospitalizations/'+key+'/'+id);
  }
}
