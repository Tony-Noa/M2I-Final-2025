package org.example.tournament.dto.tourney;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class TourneyResponseDto {

    private int id;
    private String name;
    private String type;
    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate signStartDate;
    private LocalDate signEndDate;
    private String gameCategory;
    private int founderId;


}

// Il semble qu'il y a pas plus à rajouter ici non plus