package org.example.tournament.service;

import org.example.tournament.dto.match.MatchReceiveDto;
import org.example.tournament.dto.match.MatchResponseDto;
import org.example.tournament.entity.Match;
import org.example.tournament.exception.NotFoundException;
import org.example.tournament.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    public MatchResponseDto create (MatchReceiveDto matchReceiveDto){
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
