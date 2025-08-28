package org.example.tournament.dto.userAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.dto.tourney.TourneyResponseDto;
import org.example.tournament.entity.Tourney;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class UserAccountResponseDto {
    private int id;
    private String username;
    private String email;
    private int role;
    private String pp; // Profile picture
    private List<TourneyResponseDto> createdTourneys;
    private List<TourneyResponseDto> joinedTourneys;
}
