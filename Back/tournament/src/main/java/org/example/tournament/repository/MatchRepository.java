package org.example.tournament.repository;

import org.example.tournament.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    /*

    // Ci-dessous sont des exemples de requetes directs qu'on lancerait quand on cliquerait sur certaines pages ou actions

    // faire une requete "from match where p1 ou p2" = idcherché @
    @Query("SELECT m FROM Match m WHERE m.p1 == :id OR m.p2 == :id")
    List<Match> getAllMatchesOfAPlayer(@Param("id") int id);
    // recuperer les matchs d'un utilisateur s'il est p1 & p2 je la stock sur l'utilisateur et je renvoie tout ça

    @Query("SELECT m FROM Match m WHERE m.p1 == :id")
    List<Match> getAllMatchesOfAPlayerIf1(@Param("id") int id);
    // recuperer les matchs d'un utilisateur s'il est p1, je la stock sur l'utilisateur et je renvoie tout ça

    @Query("SELECT m FROM Match m WHERE m.p2 == :id")
    List<Match> getAllMatchesOfAPlayerIf2(@Param("id") int id);
    // recuperer les matchs d'un utilisateur s'il est p2, je la stock sur l'utilisateur et je renvoie tout ça



     */

}