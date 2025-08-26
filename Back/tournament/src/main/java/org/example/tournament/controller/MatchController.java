package org.example.tournament.controller;

import jakarta.validation.Valid;
import org.example.tournament.dto.match.MatchReceiveDto;
import org.example.tournament.dto.match.MatchResponseDto;
import org.example.tournament.repository.MatchRepository;
import org.example.tournament.service.MatchService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("match")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MatchController {

    private MatchService matchService;
    //private MatchRepository matchRepository;

    public MatchController(MatchService matchService){this.matchService = matchService;}

    @GetMapping("/all")
    public ResponseEntity<List<MatchResponseDto>> getAll(){ return ResponseEntity.ok(matchService.get());}

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDto> get (@PathVariable int id){
        //matchRepository.getAllMatchesOfAPlayer(id);
        return ResponseEntity.ok(matchService.get(id));
    }

    @PostMapping
    public ResponseEntity<MatchResponseDto> create (@Valid @RequestBody MatchReceiveDto matchReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(matchService.create(matchReceiveDto));
    }

    @PutMapping("/{id}") //put met une nouvelle donnée
    public ResponseEntity<MatchResponseDto> update (@PathVariable int id, @RequestBody MatchReceiveDto matchReceiveDto){
        return ResponseEntity.ok(matchService.update(id, matchReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        matchService.delete(id);
        return ResponseEntity.ok(String.format("Match at id : %s is deleted", id));

    }
}
