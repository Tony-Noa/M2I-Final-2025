package org.example.tournament.dto.userAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.Tourney;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class



UserAccountResponseDto {
    private int id;

    private String username;
    private String password;
    private String pp; // Profile picture
    private List<Tourney> createdTourneys;
    private List<Tourney> joinedTourneys;
}
