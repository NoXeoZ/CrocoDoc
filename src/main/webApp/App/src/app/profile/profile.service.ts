import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Profile} from "../model/profile";
type EntityResponseType = HttpResponse<Profile>; // pareil

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private httpClient:HttpClient) { }
  getProfiles() : Observable<Array<Profile>> {
    return this.httpClient.get<Array<Profile>>('/profiles');
  }
  getProfile(id: number) : Observable<Profile> {
    return this.httpClient.get<Profile>('/profiles/' + id);
  }
  deleteProfile(id: number): Observable<EntityResponseType> {
    return this.httpClient.delete<Profile>('/profiles/' + id, { observe: 'response' });
  }
  createProfile(profile:Profile): Observable<EntityResponseType> {
    return this.httpClient.post<Profile>('/profiles', profile, { observe: 'response' });
  }
  updateProfile(profile: Profile): Observable<EntityResponseType> {
    return this.httpClient.post<Profile>('/profiles' + '/' + profile.id, profile, { observe: 'response' });
  }
}
