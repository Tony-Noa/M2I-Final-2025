package org.example.tournament.dto.tourney;


import jakarta.validation.constraints.Pattern;
import org.example.tournament.enums.Tformat;
import org.example.tournament.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.*;
import org.example.tournament.repository.GameCategoryRepository;
import org.example.tournament.repository.UserAccountRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class TourneyReceiveDto {

    private String name;

    private String format;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private String creationDate;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private String startDate;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private String signStartDate;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private String signEndDate;

    //@NotEmpty(message = "Please input a valid founder")
    //private int founderId;
    private int founderId;
    //private UserAccount Founder;

    private int gameCategoryId;
    //private GameCategory gameCategory;

    private List<UserAccount> players;

    private List<Match> matches;

    public Tourney dtoToEntity(GameCategoryRepository gameCategoryRepository, UserAccountRepository userAccountRepository) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return Tourney.builder()
                .name(getName())
                .format(Tformat.valueOf(format))
                .creationDate(LocalDate.parse(getCreationDate(), dateTimeFormatter))
                .startDate(LocalDate.parse(getStartDate(), dateTimeFormatter))
                .signStartDate(LocalDate.parse(getStartDate(), dateTimeFormatter))
                .signEndDate(LocalDate.parse(getSignEndDate(), dateTimeFormatter))
                .gameCategory(gameCategoryRepository.findById(gameCategoryId).orElseThrow(NotFoundException::new))
                .founder(userAccountRepository.findById(founderId).orElseThrow(NotFoundException::new))
                //.players(getPlayers())
                //.matches(getMatches())
                .build();
    }
}

// Semble qu il y a pas besoin de mettre dans le receive ici

