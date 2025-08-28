import { MatchType } from "./match";

export interface RoundType {
    id: number,
    name: string,
    matches: MatchType[]
}

export function createRound(partial: Partial<RoundType> = {}): RoundType {
    return {
        id: -1,
        name: "Round -1",
        matches: [],
        ...partial, // surcharge les valeurs par défaut
    };
}

export function createNextRound(previousRound: RoundType, partial: Partial<RoundType> = {}): RoundType {
    let result: RoundType = {
        id: -1,
        name: "Round -1",
        matches: [],
        ...partial, // surcharge les valeurs par défaut
    };

    for (let i = 0; i < result.matches.length; i++) {
        if (previousRound.matches[i * 2].isTerminated)
            result.matches[i].opponentA = previousRound.matches[i * 2].winner;
        else
            result.matches[i].opponentA = "WINNER " + previousRound.matches[i * 2].position;
        if (previousRound.matches[i * 2 + 1].isTerminated)
            result.matches[i].opponentB = previousRound.matches[i * 2 + 1].winner;
        else
            result.matches[i].opponentB = "WINNER " + previousRound.matches[i * 2 + 1].position;
    }
    return result;
}

//const u2 = createRound({ name: "Alice" });