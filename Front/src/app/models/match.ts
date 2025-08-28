export interface MatchType {
    id: number,
    opponentA: string,
    opponentB: string,
    scoreA: number,
    scoreB: number,
    idTournament: number,
    position: string,
    isTerminated: boolean,
    winner: string
}

export function createMatch(partial: Partial<MatchType> = {}): MatchType {
    return {
        id: -1,
        opponentA: "Player 1",
        opponentB: "Player 2",
        scoreA: 0,
        scoreB: 0,
        idTournament: -1,
        position: "0.0",
        isTerminated: false,
        winner: "WIN",
        ...partial, // surcharge les valeurs par défaut
    };
}

export function endMatch(match:MatchType){
    match.isTerminated=true;
    match.winner=(match.scoreA>match.scoreB)?match.opponentA:match.opponentB; 
  }