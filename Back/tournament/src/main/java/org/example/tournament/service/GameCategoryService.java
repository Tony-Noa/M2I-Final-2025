package org.example.tournament.service;

import org.example.tournament.dto.gameCategory.GameCategoryReceiveDto;
import org.example.tournament.dto.gameCategory.GameCategoryResponseDto;
import org.example.tournament.entity.GameCategory;
import org.example.tournament.exception.NotFoundException;
import org.example.tournament.repository.GameCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameCategoryService {

    private final GameCategoryRepository gameCategoryRepository;

    public GameCategoryService(GameCategoryRepository gameCategoryRepository){
        this.gameCategoryRepository = gameCategoryRepository;
    }

    public GameCategoryResponseDto create (GameCategoryReceiveDto gameCategoryReceiveDto){
        return gameCategoryRepository.save(gameCategoryReceiveDto.dtoToEntity()).entityToDto();
    }

    public GameCategoryResponseDto get(int id){
        return gameCategoryRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<GameCategoryResponseDto> get(){
        return gameCategoryRepository.findAll().stream().map(GameCategory::entityToDto).toList();
    }

    public GameCategoryResponseDto update(int id, GameCategoryReceiveDto gameCategoryReceiveDto){
        GameCategory gameCategoryFound = gameCategoryRepository.findById(id).orElseThrow(NotFoundException::new);
        GameCategory gameCategoryGet = gameCategoryReceiveDto.dtoToEntity();
        gameCategoryFound.setName(gameCategoryGet.getName());
        gameCategoryFound.setIcon(gameCategoryGet.getIcon());
        gameCategoryFound.setLogo(gameCategoryGet.getLogo());
        return gameCategoryRepository.save(gameCategoryFound).entityToDto();
    }

    public void delete(int id){
        gameCategoryRepository.deleteById(id);
    }
}
