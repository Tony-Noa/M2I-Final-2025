package org.example.tournament.dto.tourney;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.Tformat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class TourneyResponseDto {

    private int id;
    private String name;
    private String format;
    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate signStartDate;
    private LocalDate signEndDate;
    private String gameCategory;
    private int userAccountId;


}

// Il semble qu'il y a pas plus à rajouter ici non plus