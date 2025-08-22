package org.example.tournament.dto.match;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;

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
    private int round;
    private int tourneyId;
}
