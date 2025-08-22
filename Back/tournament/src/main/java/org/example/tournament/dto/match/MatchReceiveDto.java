package org.example.tournament.dto.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.Match;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class MatchReceiveDto {

    private UserAccount p1;
    private UserAccount p2;
    private int resultP1;
    private int resultP2;
    private int round;
    private Tourney tourney;

    public Match dtoToEntity() {

        return Match.builder()
                .p1(getP1())
                .p2(getP2())
                .resultP1(getResultP1())
                .resultP2(getResultP2())
                .round(getRound())
                .tourney(getTourney())
                .build();
    }

}
