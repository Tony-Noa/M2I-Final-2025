package org.example.tournament.dto.tourney;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.GameCategory;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class TourneyReceiveDto {

    private String name;

    private String type;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private LocalDate creationDate;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private LocalDate startDate;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private LocalDate signStartDate;

    @Pattern(regexp = "[0-9]{4}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{2}" , message = "Date should be as yyyy-MM-dd format!")
    private LocalDate signEndDate;

    @NotEmpty(message = "Please input a valid founder")
    private UserAccount founder;

    private GameCategory gameCategory;

    public Tourney dtoToEntity() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return Tourney.builder()
                .name(getName())
                .type(getType())
                .creationDate(getCreationDate())
                .startDate(getStartDate())
                .signStartDate(getSignEndDate())
                .signEndDate(getSignEndDate())
                .gameCategory(getGameCategory())
                .founder(getFounder())
                .build();
    }
}

// Semble qu il y a pas besoin de mettre dans le receive ici

