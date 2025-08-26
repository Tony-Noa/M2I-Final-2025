package org.example.tournament.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.tournament.dto.tourney.TourneyResponseDto;
import org.example.tournament.enums.Tformat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="tourney")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Tourney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tourneyId;

    private String name;
    private Tformat format;
    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate signStartDate;
    private LocalDate signEndDate;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "gameCategoryId")
    private GameCategory gameCategory;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "founderId")
    private UserAccount founder;

    @ManyToMany(mappedBy = "joinedTourneys")
    private List<UserAccount> players;

    @OneToMany(mappedBy = "matchId")
    private List<Match> matches;

    public TourneyResponseDto entityToDto(){
        return TourneyResponseDto.builder()
                .name(getName())
                .id(getTourneyId())
                .format(String.valueOf(format))
                .creationDate(getCreationDate())
                .startDate(getStartDate())
                .signStartDate(getSignEndDate())
                .signEndDate(getSignEndDate())
                .gameCategory(getGameCategory().getName())
                .userAccountId(getFounder().getUserAccountId())
                .build();

    }


}
