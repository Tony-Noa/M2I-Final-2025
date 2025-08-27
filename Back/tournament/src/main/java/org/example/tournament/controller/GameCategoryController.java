package org.example.tournament.controller;

import jakarta.validation.Valid;
import org.example.tournament.dto.gameCategory.GameCategoryReceiveDto;
import org.example.tournament.dto.gameCategory.GameCategoryResponseDto;
import org.example.tournament.service.GameCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gamecategory")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GameCategoryController {
    private GameCategoryService gameCategoryService;

    public GameCategoryController(GameCategoryService gameCategoryService){this.gameCategoryService = gameCategoryService;}

    @GetMapping("/public/all")
    public ResponseEntity<List<GameCategoryResponseDto>> getAll(){ return ResponseEntity.ok(gameCategoryService.get());}

    @GetMapping("/public/{id}")
    public ResponseEntity<GameCategoryResponseDto> get (@PathVariable int id){
        return ResponseEntity.ok(gameCategoryService.get(id));
    }

    @PostMapping("/public")
    public ResponseEntity<GameCategoryResponseDto> create (@Valid @RequestBody GameCategoryReceiveDto gameCategoryReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameCategoryService.create(gameCategoryReceiveDto));
    }

    @PutMapping("/public/{id}") //put met une nouvelle donnée
    public ResponseEntity<GameCategoryResponseDto> update (@PathVariable int id, @RequestBody GameCategoryReceiveDto gameCategoryReceiveDto){
        return ResponseEntity.ok(gameCategoryService.update(id, gameCategoryReceiveDto));
    }

    @DeleteMapping("/public/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        gameCategoryService.delete(id);
        return ResponseEntity.ok(String.format("GameCategory at id : %s is deleted", id));

    }


}
