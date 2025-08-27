package org.example.tournament.dto.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder


public class MatchResponseDto {

    private int id;
    private int p1Id;
    private int p2Id;
    private int resultP1;
    private int resultP2;
    private String position;
    private int tourneyId;
}
