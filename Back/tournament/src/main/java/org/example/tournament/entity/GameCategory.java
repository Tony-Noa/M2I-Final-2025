package org.example.tournament.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.dto.gameCategory.GameCategoryResponseDto;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;

import java.util.List;

@Entity
@Table(name="game_category")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class GameCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    private String name;
    private String icon;
    private String logo;

    @OneToMany(mappedBy = "gameCategory")
    private List<Tourney> tourneys;

    public GameCategoryResponseDto entityToDto(){
        return GameCategoryResponseDto.builder()
                .id(getGameId())
                .name(getName())
                .icon(getIcon())
                .logo(getLogo())
                .build();

    }

}
