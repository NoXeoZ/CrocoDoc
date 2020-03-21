import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {User} from "../model/user";
import {HttpClient} from "@angular/common/http";

class EntityResponseType {
}

@Injectable({
  providedIn: 'root'
})
export class UserRegularService {

  constructor(private httpClient:HttpClient) { }

  getId(key:string) : Observable<number> {
    return this.httpClient.get<number>('/user-regular/'+key);
  }

  getUser(id: number,key:string) : Observable<User> {
    return this.httpClient.get<User>('/user/'+id+'/' + key);
  }

  updateUser(user: User,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<User>('/user-regular/' +user.id+ '/' + key, user, { observe: 'response' });
  }
}
