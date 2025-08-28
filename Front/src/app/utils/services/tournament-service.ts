import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TournamentType } from '../../models/tournament/tournament';
import { TournamentTypeDto } from '../../models/tournament/tournamentDto';

@Injectable({
  providedIn: 'root'
})
export class TourneyService {
  private baseUrl = 'http://localhost:8090/api/private/tourney';

  constructor(private http: HttpClient) { }

  get(id: number): Observable<TournamentType> {
    return this.http.get<TournamentType>(`${this.baseUrl}/${id}`);
  }

  create(tourney: TournamentTypeDto): Observable<TournamentType> {
    return this.http.post<TournamentType>(this.baseUrl, tourney);
  }

  update(id: number, tourney: TournamentTypeDto): Observable<TournamentType> {
    return this.http.put<TournamentType>(`${this.baseUrl}/${id}`, tourney);
  }
}

