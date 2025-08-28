import { createMatch, MatchType } from "../match";
import { createNextRound, createRound, RoundType } from "../round";
import { createUser, UserType } from "../user/user";
import { TournamentTypeDto } from "./tournamentDto";

export class TournamentType {
    id: number;
    name: string;
    players: UserType[];
    rounds: RoundType[];
    creationDate: string;
    startDate: string;
    signStartDate: string;
    signEndDate: string;
    founderId: number;
    gameCategoryId: number;




    constructor(
        id: number,
        name: string,
        players: UserType[],
        rounds: RoundType[],
        creationDate: string,
        startDate: string,
        signStartDate: string,
        signEndDate: string,
        founderId: number,
        gameCategoryId: number
    ) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.rounds = rounds;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.signStartDate = signStartDate;
        this.signEndDate = signEndDate;
        this.founderId = founderId;
        this.gameCategoryId = gameCategoryId;
    }

    /**
     * Factory pour créer un tournoi
     */
    static create(nbParticipants: number, partial: Partial<TournamentType> = {}): TournamentType {
        const users: UserType[] = TournamentType.initUsers(nbParticipants);

        const base = new TournamentType(
            -1,
            "My Tournament",
            users,
            TournamentType.initRounds(nbParticipants, users),
            new Date().toISOString(), // creationDate
            "",                       // startDate
            "",                       // signStartDate
            "",                       // signEndDate
            -1,                       // founderId
            -1                        // gameCategoryId
        );

        // surcharge avec les valeurs partielles
        return Object.assign(base, partial);
    }

    private static initMatches(nbParticipants: number, numRound: number): MatchType[] {
        let result: MatchType[] = [];
        for (let i: number = 0; i < Math.floor(nbParticipants / 2); i++) {
            result.push(createMatch({ position: numRound + "-" + (i + 1) }));
        }
        return result;
    }

    private static initRounds(nbParticipants: number, users: UserType[]): RoundType[] {
        let result: RoundType[] = [];
        result.push(createRound({
            matches: TournamentType.initFirstRound(users)
        }));
        for (let i: number = 1; i < Math.log(nbParticipants) / Math.log(2); i++) {
            result.push(
                createNextRound(
                    result[i - 1],
                    {
                        matches: TournamentType.initMatches(Math.floor(nbParticipants / Math.pow(2, i)), i + 1)
                    })
            );
        }
        return result;
    }

    private static initFirstRound(users: UserType[]): MatchType[] {
        let result: MatchType[] = [];
        for (let i: number = 0; i < users.length; i = i + 2) {
            result.push(
                createMatch({
                    opponentA: users[i].username,
                    opponentB: users[i + 1].username,
                    position: "1-" + ((i + 2) / 2)
                })
            );
        }
        return result;
    }

    private static initUsers(nbParticipants: number): UserType[] {
        let result: UserType[] = [];
        for (let i: number = 1; i <= nbParticipants; i++) {
            result.push(
                createUser({
                    username: "Player " + i
                })
            );
        }
        return result;
    }


}

// Exemple d'utilisation
//const t1 = Tournament.create(8, { name: "Tournoi Test" });
//console.log(t1);
