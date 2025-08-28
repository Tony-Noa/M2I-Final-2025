import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserType } from '../../models/user/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceTs {
  private baseUrl = "http://localhost:8090/api/"

  constructor(private http: HttpClient) { }

  register(id: number): Observable<UserType> {
    return this.http.get<UserType>(this.baseUrl + "public/useraccount/" + id);
  }

}
