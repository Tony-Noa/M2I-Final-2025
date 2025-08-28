package org.example.tournament.controller;

import jakarta.validation.Valid;
import org.example.tournament.dto.userAccount.UserAccountReceiveDto;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;
import org.example.tournament.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("useraccount")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserAccountController {
    private UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService){this.userAccountService = userAccountService;}

    @GetMapping("/public/all")
    public ResponseEntity<List<UserAccountResponseDto>> getAll(){ return ResponseEntity.ok(userAccountService.get());}

    @GetMapping("/public/{id}")
    public ResponseEntity<UserAccountResponseDto> get (@PathVariable int id){
        return ResponseEntity.ok(userAccountService.get(id));
    }
    /*
    @PostMapping("/public")
    public ResponseEntity<UserAccountResponseDto> create (@Valid @RequestBody UserAccountReceiveDto userAccountReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userAccountService.create(userAccountReceiveDto));
    }
    */


    @PutMapping("/public/{id}") //put met une nouvelle donnée
    public ResponseEntity<UserAccountResponseDto> update (@PathVariable int id, @RequestBody UserAccountReceiveDto userAccountReceiveDto){
        return ResponseEntity.ok(userAccountService.update(id, userAccountReceiveDto));
    }

    @PutMapping("/public/{userId}/{tourneyId}") //put met une nouvelle donnée
    public ResponseEntity<UserAccountResponseDto> register (@PathVariable Integer userId, @PathVariable Integer tourneyId){
        return ResponseEntity.ok(userAccountService.register(userId, tourneyId));
    }

    @DeleteMapping("/private/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        userAccountService.delete(id);
        return ResponseEntity.ok(String.format("UserAccount at id : %s is deleted", id));

    } // Ici vu qu'on est en private, il faut faire un login et recuperer un token qu'on mettra sur Postman (par exemple)
      // dans la rubrique "authorization" => auth type bearer token => Mettre le token (sans guillemet ou "token":" ", juste direct)

}
