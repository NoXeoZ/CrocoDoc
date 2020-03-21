import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user"; // retire ça pour voir ce que tu dois changer
type EntityResponseType = HttpResponse<User>; // pareil

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  getUsers(key: string) : Observable<Array<User>> {
    return this.httpClient.get<Array<User>>('/user/'+key);
  }
  getUser(id: number,key:string) : Observable<User> {
    return this.httpClient.get<User>('/user/'+id+'/' + key);
  }


  deleteUser(id: number,key:string): Observable<EntityResponseType> {
    return this.httpClient.delete<User>('/user/'+id+'/' +key , { observe: 'response' });
  }
  createUser(user:User,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<User>('/user/'+key, user, { observe: 'response' });
  }
  updateUser(user: User,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<User>('/user/' +user.id+ '/' + key, user, { observe: 'response' });
  }
  /*
  updateUserForAdmin(user: User,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<User>('/users/' +key+ '/' + user.id, user, { observe: 'response' });
  }
  getUserForAdmin(user: User,key:string): Observable<EntityResponseType> {
    return this.httpClient.post<User>('/users/' +key+ '/' + user.id, user, { observe: 'response' });
  }*/
}
