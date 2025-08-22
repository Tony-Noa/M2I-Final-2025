package org.example.tournament.service;


import org.example.tournament.dto.match.MatchReceiveDto;
import org.example.tournament.dto.match.MatchResponseDto;
import org.example.tournament.entity.Match;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;
import org.example.tournament.exception.NotFoundException;
import org.example.tournament.repository.MatchRepository;
import org.example.tournament.repository.TourneyRepository;
import org.example.tournament.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
/*

private UserAccount p1;

private UserAccount p2;

private Tourney */
    private final MatchRepository matchRepository;
    private final UserAccountRepository userAccountRepository;
    private final TourneyRepository tourneyRepository;

    public MatchService(MatchRepository matchRepository, UserAccountRepository userAccountRepository, TourneyRepository tourneyRepository  ){
        this.matchRepository = matchRepository;
        this.userAccountRepository = userAccountRepository;
        this.tourneyRepository = tourneyRepository;
    }

    public MatchResponseDto create (MatchReceiveDto matchReceiveDto, int p1Id, int p2Id, int tourneyId){
        UserAccount player1 = userAccountRepository.findById(p1Id).orElseThrow(NotFoundException::new);
        matchReceiveDto.setP1(player1);

        UserAccount player2 = userAccountRepository.findById(p2Id).orElseThrow(NotFoundException::new);
        matchReceiveDto.setP2(player2);

        Tourney tourney = tourneyRepository.findById(tourneyId).orElseThrow(NotFoundException::new);
        matchReceiveDto.setTourney(tourney);
        player1.getMatches().add(matchReceiveDto.dtoToEntity());
        player2.getMatches().add(matchReceiveDto.dtoToEntity());

        return matchRepository.save(matchReceiveDto.dtoToEntity()).entityToDto();
    }

    public MatchResponseDto get(int id){
        return matchRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<MatchResponseDto> get(){
        return matchRepository.findAll().stream().map(Match::entityToDto).toList();
    }

    public MatchResponseDto update(int id, MatchReceiveDto matchReceiveDto){
        Match matchFound = matchRepository.findById(id).orElseThrow(NotFoundException::new);
        Match matchGet = matchReceiveDto.dtoToEntity();
        matchFound.setResultP1(matchGet.getResultP1());
        matchFound.setResultP2(matchGet.getResultP2());
        //matchFound.setRound(matchGet.getRound());
        // Voir si on veut changer le joueur qui joue

        return matchRepository.save(matchFound).entityToDto();
    }

    public void delete(int id){
        matchRepository.deleteById(id);
    }

}
