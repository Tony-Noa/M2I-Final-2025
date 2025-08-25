package org.example.tournament.dto.userAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.Match;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserAccountReceiveDto {

    private String username;
    private String password;
    private String pp; // Profile picture
    //private List<Match> matches; ici je veux pas recevoir les matchs, juste les recuperer quand je les renvoie

    //private List<Tourney> createdTourneys;
    //private List<Tourney> joinedTourneys;

    public UserAccount dtoToEntity() {
        return UserAccount.builder()
                .username(getUsername())
                .password(getPassword())
                .pp(getPp())

                //.matches(getMatches())
                //.createdTourneys(getCreatedTourneys())
                //.joinedTourneys(getJoinedTourneys())
                .build();
    }

}
