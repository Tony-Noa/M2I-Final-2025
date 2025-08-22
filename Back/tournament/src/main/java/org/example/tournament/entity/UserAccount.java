package org.example.tournament.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;

import java.util.List;

@Entity
@Table(name="userAccount")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userAccountId;

    private String username;
    private String password;
    private String pp; // Profile picture

    @OneToMany(mappedBy = "founder")
    private List<Tourney> createdTourneys;

    @ManyToMany
    @JoinTable(name = "player_tourney",
        joinColumns = @JoinColumn(name = "playerId"),
        inverseJoinColumns = @JoinColumn(name = "tourneyId"))
    private List<Tourney> joinedTourneys;

    @OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "matchId")
    private List<Match> match;


    public UserAccountResponseDto entityToDto(){
        return UserAccountResponseDto.builder()
                .id(getUserAccountId())
                .username(getUsername())
                .password(getPassword())
                .pp(getPp())
                .build();

    }


}
