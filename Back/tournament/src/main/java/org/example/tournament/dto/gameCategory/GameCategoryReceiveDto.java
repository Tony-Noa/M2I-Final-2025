package org.example.tournament.dto.gameCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.GameCategory;
import org.example.tournament.entity.Tourney;

import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class GameCategoryReceiveDto {

    private String name;
    private String icon;
    private String logo;
    private List<Tourney> tourneys;

    public GameCategory dtoToEntity() {

        return GameCategory.builder()
                .name(getName())
                .icon(getIcon())
                .logo(getLogo())
                .tourneys(getTourneys())
                .build();
    }
}
