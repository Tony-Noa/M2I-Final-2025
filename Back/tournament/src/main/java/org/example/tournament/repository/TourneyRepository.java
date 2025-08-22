package org.example.tournament.repository;

import org.example.tournament.entity.Tourney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourneyRepository extends JpaRepository<Tourney, Integer> {
}
