package org.example.tournament.dto.gameCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class GameCategoryResponseDto {

    private int id;

    private String name;
    private String icon;
    private String logo;


}
