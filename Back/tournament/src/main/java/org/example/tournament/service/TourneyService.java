package org.example.tournament.service;

import org.apache.catalina.User;
import org.example.tournament.dto.tourney.TourneyReceiveDto;
import org.example.tournament.dto.tourney.TourneyResponseDto;
import org.example.tournament.entity.GameCategory;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;
import org.example.tournament.exception.NotFoundException;
import org.example.tournament.repository.GameCategoryRepository;
import org.example.tournament.repository.TourneyRepository;
import org.example.tournament.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourneyService {

    private final TourneyRepository tourneyRepository;
    private final UserAccountRepository userAccountRepository;
    private final GameCategoryRepository gameCategoryRepository;


    public TourneyService(TourneyRepository tourneyRepository, UserAccountRepository userAccountRepository, GameCategoryRepository gameCategoryRepository){
        this.tourneyRepository = tourneyRepository;
        this.userAccountRepository = userAccountRepository;
        this.gameCategoryRepository = gameCategoryRepository;
    }

    public TourneyResponseDto create (TourneyReceiveDto tourneyReceiveDto, int founderId, int gameCategoryId){
        UserAccount founder = userAccountRepository.findById(founderId).orElseThrow(NotFoundException::new);
        tourneyReceiveDto.setFounder(founder);
        GameCategory gameCategory = gameCategoryRepository.findById(gameCategoryId).orElseThrow(NotFoundException::new);
        tourneyReceiveDto.setGameCategory(gameCategory);
        founder.getCreatedTourneys().add(tourneyReceiveDto.dtoToEntity());
        return tourneyRepository.save(tourneyReceiveDto.dtoToEntity()).entityToDto();
    }

    public TourneyResponseDto get(int id){
        return tourneyRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<TourneyResponseDto> get(){
        return tourneyRepository.findAll().stream().map(Tourney::entityToDto).toList();
    }

    public TourneyResponseDto update(int id, TourneyReceiveDto tourneyReceiveDto){
        Tourney tourneyFound = tourneyRepository.findById(id).orElseThrow(NotFoundException::new);
        Tourney tourneyGet = tourneyReceiveDto.dtoToEntity();
        tourneyFound.setName(tourneyGet.getName());
        tourneyFound.setType(tourneyGet.getType());
        //tourneyFound.setCreationDate(tourneyGet.getCreationDate());
        tourneyFound.setStartDate(tourneyGet.getStartDate());
        tourneyFound.setSignStartDate(tourneyGet.getSignStartDate());
        tourneyFound.setSignEndDate(tourneyGet.getSignEndDate());

        return tourneyRepository.save(tourneyFound).entityToDto();
    }

    public void delete(int id){
        tourneyRepository.deleteById(id);
    }

}
