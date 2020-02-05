import {HttpClient, HttpResponse} from "@angular/common/http";
import {Structure} from "../model/structure";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Authetification} from "../model/authetification";

type EntityResponseType = HttpResponse<Structure>;
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  constructor(private httpClient:HttpClient) { }
  logIn(authentication:Authetification) : Observable<string> {
    return this.httpClient.get<string>('/connect'+'/'+authentication.login+'/'+authentication.password);
  }
}
