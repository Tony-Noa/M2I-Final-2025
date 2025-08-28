package org.example.tournament.controller;

import jakarta.validation.Valid;
import org.example.tournament.dto.tourney.TourneyReceiveDto;
import org.example.tournament.dto.tourney.TourneyResponseDto;
import org.example.tournament.dto.userAccount.UserAccountReceiveDto;
import org.example.tournament.service.TourneyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/private/tourney")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class TourneyController {

    private TourneyService tourneyService;

    public TourneyController(TourneyService tourneyService){this.tourneyService = tourneyService;}

    @GetMapping("/public/all")
    public ResponseEntity<List<TourneyResponseDto>> getAll(){ return ResponseEntity.ok(tourneyService.get());}

    @GetMapping("/public/{id}")
    public ResponseEntity<TourneyResponseDto> get (@PathVariable int id){
        return ResponseEntity.ok(tourneyService.get(id));
    }


    @PostMapping()
    public ResponseEntity<TourneyResponseDto> create ( @RequestBody TourneyReceiveDto tourneyReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(tourneyService.create(tourneyReceiveDto));
    }

    @PutMapping("/public/{id}") //put met une nouvelle donnée
    public ResponseEntity<TourneyResponseDto> update (@PathVariable int id, @RequestBody TourneyReceiveDto tourneyReceiveDto){
        return ResponseEntity.ok(tourneyService.update(id, tourneyReceiveDto));
    }

    @DeleteMapping("/public/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        tourneyService.delete(id);
        return ResponseEntity.ok(String.format("Tourney at id : %s is deleted", id));

    }

}
