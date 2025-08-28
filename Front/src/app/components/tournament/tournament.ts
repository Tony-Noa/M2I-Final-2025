import { Component } from '@angular/core';
import { Match } from '../match/match';
import { createMatch, MatchType } from '../../models/match';
import { createRound, RoundType } from '../../models/round';
import { TournamentType } from '../../models/tournament/tournament';

@Component({
  selector: 'app-tournament',
  imports: [Match],
  templateUrl: './tournament.html',
  styleUrl: './tournament.css'
})
export class Tournament {
  nbParticipants: number = 16;
  tournament: TournamentType = TournamentType.create(this.nbParticipants);



  changeBracket(match: MatchType) {
    let numNextRound: number = Number(match.position.charAt(0));
    let isOdd: boolean = (Number(match.position.charAt(2)) % 2 == 0) ? false : true;
    let numNextMatch: number = (isOdd) ? (Number(match.position.charAt(2)) + 1) / 2 - 1 : Number(match.position.charAt(2)) / 2 - 1;
    if (numNextRound != this.tournament.rounds.length) {
      if (isOdd)
        this.tournament.rounds[numNextRound].matches[numNextMatch].opponentA = match.winner;
      else
        this.tournament.rounds[numNextRound].matches[numNextMatch].opponentB = match.winner;
    }
    console.log(numNextMatch);

  }

  calculMarginTop(numRound: number): number {
    //Utilisation de fonction arithético-géométrique : U0=10px Un+1=Un*2+5 ==> Un=2^n(U0-(5/(1-2)) + 5/(1-2))
    let uzero: number = 30;
    return Math.pow(2, numRound) * (uzero - ((uzero / 2) / (1 - 2))) + ((uzero / 2) / (1 - 2));
  }

  calculDistanceLink(numRound: number): number {
    let uzero = 45;
    return (uzero * Math.pow(2, numRound));
  }
}


