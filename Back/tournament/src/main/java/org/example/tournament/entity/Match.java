package org.example.tournament.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.dto.match.MatchResponseDto;

@Entity
@Table(name="tournamentmatch")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "p1Id")
    private UserAccount p1;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "p2Id")
    private UserAccount p2;

    private int resultP1;
    private int resultP2;

    private int round;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    private Tourney tourney;

    public MatchResponseDto entityToDto(){
        return MatchResponseDto.builder()
                .id(getMatchId())
                .p1Id(getP1().getUserAccountId())
                .p2Id(getP2().getUserAccountId())
                .resultP1(getResultP1())
                .resultP2(getResultP2())
                .round(getRound())
                .tourneyId(getTourney().getTourneyId())
                .build();
    }


}
