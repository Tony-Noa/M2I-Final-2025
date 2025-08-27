package org.example.tournament.dto.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.Match;
import org.example.tournament.exception.NotFoundException;
import org.example.tournament.repository.TourneyRepository;
import org.example.tournament.repository.UserAccountRepository;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class MatchReceiveDto {

    private int p1Id;
    private int p2Id;
    private int resultP1 = 0;
    private int resultP2 = 0;
    private String position;

    //private Tourney tourney;
    private int tourneyId;

    public Match dtoToEntity(UserAccountRepository userAccountRepository, TourneyRepository tourneyRepository) {

        return Match.builder()
                .p1(userAccountRepository.findById(p1Id).orElseThrow(NotFoundException::new))
                .p2(userAccountRepository.findById(p2Id).orElseThrow(NotFoundException::new))
                .resultP1(getResultP1())
                .resultP2(getResultP2())
                .position(getPosition())
                .tourney(tourneyRepository.findById(tourneyId).orElseThrow(NotFoundException::new))
                .build();
    }

}
