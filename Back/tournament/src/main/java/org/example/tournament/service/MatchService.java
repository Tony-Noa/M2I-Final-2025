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

    private final MatchRepository matchRepository;
    private final UserAccountRepository userAccountRepository;
    private final TourneyRepository tourneyRepository;

    public MatchService(MatchRepository matchRepository, UserAccountRepository userAccountRepository, TourneyRepository tourneyRepository  ){
        this.matchRepository = matchRepository;
        this.userAccountRepository = userAccountRepository;
        this.tourneyRepository = tourneyRepository;
    }

    public MatchResponseDto create (MatchReceiveDto matchReceiveDto){
        UserAccount player1 = userAccountRepository.findById(matchReceiveDto.getP1Id()).orElseThrow(NotFoundException::new);
        //matchReceiveDto.setP1(player1);

        UserAccount player2 = userAccountRepository.findById(matchReceiveDto.getP2Id()).orElseThrow(NotFoundException::new);
        //matchReceiveDto.setP2(player2);

        Tourney tourney = tourneyRepository.findById(matchReceiveDto.getTourneyId()).orElseThrow(NotFoundException::new);
        //matchReceiveDto.setTourney(tourney);
        player1.getMatches().add(matchReceiveDto.dtoToEntity(userAccountRepository, tourneyRepository));
        player2.getMatches().add(matchReceiveDto.dtoToEntity(userAccountRepository, tourneyRepository));
        tourney.getMatches().add(matchReceiveDto.dtoToEntity(userAccountRepository, tourneyRepository));

        return matchRepository.save(matchReceiveDto.dtoToEntity(userAccountRepository, tourneyRepository)).entityToDto();
    }

    public MatchResponseDto get(int id){
        return matchRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<MatchResponseDto> get(){
        return matchRepository.findAll().stream().map(Match::entityToDto).toList();
    }

    public MatchResponseDto update(int id, MatchReceiveDto matchReceiveDto){
        Match matchFound = matchRepository.findById(id).orElseThrow(NotFoundException::new);
        Match matchGet = matchReceiveDto.dtoToEntity(userAccountRepository, tourneyRepository);
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
