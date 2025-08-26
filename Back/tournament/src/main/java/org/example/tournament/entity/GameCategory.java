package org.example.tournament.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.dto.gameCategory.GameCategoryResponseDto;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;

import java.util.List;

@Entity
@Table(name="gameCategory")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data


public class GameCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameCategoryId;

    private String name;
    private String icon;
    private String logo;

    @OneToMany(mappedBy = "gameCategory")
    private List<Tourney> tourneys;

    public GameCategoryResponseDto entityToDto(){
        return GameCategoryResponseDto.builder()
                .id(getGameCategoryId())
                .name(getName())
                .icon(getIcon())
                .logo(getLogo())
                .build();

    }

}
