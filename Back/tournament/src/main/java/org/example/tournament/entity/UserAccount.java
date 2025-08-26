package org.example.tournament.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.dto.tourney.TourneyResponseDto;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="useraccount")
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

    //@OneToMany(mappedBy = "matchId")
    @Transient // Le transient permet d'ignorer l'attribut matches, on veut le recuperer pour l'envoyer au front parce qu'il faut tjr une relation quand on crée un nouvel objet
    private List<Match> matches = new ArrayList<Match>();


    @OneToMany(mappedBy = "founder")
    private List<Tourney> createdTourneys;

    @ManyToMany
    @JoinTable(name = "player_tourney",
        joinColumns = @JoinColumn(name = "playerId"),
        inverseJoinColumns = @JoinColumn(name = "tourneyId"))
    private List<Tourney> joinedTourneys;
    // TODO voir comment alimenter la liste de tournois participé d'un utilisateur mais cela se ferait surtout par la front end ?


    public UserAccountResponseDto entityToDto(){
        List<TourneyResponseDto> joinedTourneysDto = new ArrayList<>();
        for (Tourney t : joinedTourneys){
            joinedTourneysDto.add(t.entityToDto());
        }

        List<TourneyResponseDto> createdTourneysDto = new ArrayList<>();
        for (Tourney t : createdTourneys){
            createdTourneysDto.add(t.entityToDto());
        }
        return UserAccountResponseDto.builder()
                .id(getUserAccountId())
                .username(getUsername())

                .joinedTourneys(joinedTourneysDto)
                .createdTourneys(createdTourneysDto)
             //   .password(getPassword())
                .pp(getPp())
                .build();

    }


}
