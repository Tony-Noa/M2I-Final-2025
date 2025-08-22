package org.example.tournament.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.dto.tourney.TourneyResponseDto;

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
    private String type;
    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate signStartDate;
    private LocalDate signEndDate;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "gameCategoryId")
    private GameCategory gameCategory;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "userAccountId")
    private UserAccount founder;

    @ManyToMany(mappedBy = "joinedTourneys")
    private List<UserAccount> players;

    @OneToMany(mappedBy = "match")
    private List<Match> matches;

    public TourneyResponseDto entityToDto(){
        return TourneyResponseDto.builder()
                .name(getName())
                .id(getTourneyId())
                .type(getType())
                .creationDate(getCreationDate())
                .startDate(getStartDate())
                .signStartDate(getSignEndDate())
                .signEndDate(getSignEndDate())
                .gameCategory(getGameCategory().getName())
                .founderId(getFounder().getUserAccountId())
                .build();

    }


}
// TODO refaire les Dto