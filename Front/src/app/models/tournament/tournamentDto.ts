import { MatchType } from "../match";
import { UserType } from "../user/user";

export interface TournamentTypeDto {
    name: string,
    players: UserType[],
    matches: MatchType[],
    creationDate: string,
    startDate: string,
    signStartDate: string,
    signEndDate: string,
    founderId: number,
    gameCategoryId: number


}

export function createTournamentTypeDto(partial: Partial<TournamentTypeDto> = {}): TournamentTypeDto {
    let today = new Date();
    return {
        name: "My Tournament",
        players: [],
        matches: [],
        creationDate: "2505-08-08",
        startDate: String(today.getDate() + "/" + today.getMonth() + "/" + today.getFullYear()),
        signStartDate: String(today.getDate() + "/" + today.getMonth() + "/" + today.getFullYear()),
        signEndDate: String(today.getDate() + "/" + today.getMonth() + "/" + today.getFullYear()),
        founderId: -1,
        gameCategoryId: 1,
        ...partial, // surcharge les valeurs par défaut
    };
}