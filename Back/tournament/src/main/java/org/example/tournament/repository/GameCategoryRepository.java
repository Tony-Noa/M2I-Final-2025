package org.example.tournament.repository;

import org.example.tournament.entity.GameCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameCategoryRepository extends JpaRepository<GameCategory, Integer> {
}
