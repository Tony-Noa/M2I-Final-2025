import { Injectable } from '@angular/core';
import { UserDto } from '../../models/user/userDto';
import { catchError, Observable, of, tap } from 'rxjs';
import { UserType } from '../../models/user/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = "http://localhost:8090/auth/public"

  constructor(private http: HttpClient) { }

  register(user: UserDto): Observable<UserDto> {
    return this.http.post<UserDto>(this.baseUrl + "/register", user)
  }

  login(credentials: Pick<UserType, "email" | "password">): Observable<{ id: number, token: string }> {
    return this.http.post<{ id: number, token: string }>(this.baseUrl + "/login", credentials).pipe(
      tap((res) => { localStorage.setItem("token", res.token); localStorage.setItem("idUser", String(res.id)); }),
      catchError(err => {
        console.error(err.message)
        return of()
      })
    )
  }

  getToken(): string | null {
    if (typeof window !== 'undefined' && window.localStorage) {
      return localStorage.getItem('token');
    }
    return null;
  }
}
