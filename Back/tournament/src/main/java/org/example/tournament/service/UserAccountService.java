package org.example.tournament.service;

import org.example.tournament.dto.tourney.TourneyReceiveDto;
import org.example.tournament.dto.tourney.TourneyResponseDto;

import org.example.tournament.dto.security.RegisterRequestDto;
import org.example.tournament.dto.security.RegisterResponseDto;

import org.example.tournament.dto.userAccount.UserAccountReceiveDto;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;

import org.example.tournament.repository.TourneyRepository;

import org.example.tournament.enums.Role;
import org.example.tournament.exception.UserAlreadyExistException;

import org.example.tournament.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import org.example.tournament.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service

public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final TourneyRepository tourneyRepository;

    public UserAccountService(UserAccountRepository userAccountRepository, TourneyRepository tourneyRepository){
        this.userAccountRepository = userAccountRepository;
        this.tourneyRepository = tourneyRepository;
    }

    public UserAccountResponseDto create (UserAccountReceiveDto UserAccountReceiveDto){
        return userAccountRepository.save(UserAccountReceiveDto.dtoToEntity()).entityToDto();

    }

    public UserAccountResponseDto get(int id){
        return userAccountRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<UserAccountResponseDto> get(){
        return userAccountRepository.findAll().stream().map(UserAccount::entityToDto).toList();
    }

    public UserAccountResponseDto update(int id, UserAccountReceiveDto userAccountReceiveDto){
        UserAccount userAccountFound = userAccountRepository.findById(id).orElseThrow(NotFoundException::new);
        UserAccount userAccountGet = userAccountReceiveDto.dtoToEntity();
        userAccountFound.setUsername(userAccountGet.getUsername());
        userAccountFound.setPassword(userAccountGet.getPassword());
        userAccountFound.setPp(userAccountGet.getPp());
        return userAccountRepository.save(userAccountFound).entityToDto();
    }

    public void delete(int id){
        userAccountRepository.deleteById(id);
    }


    public UserAccountResponseDto register(int userId, int tourneyId){
        UserAccount playerFound = userAccountRepository.findById(userId).orElseThrow(NotFoundException::new);
        Tourney tourney = tourneyRepository.findById(tourneyId).orElseThrow(NotFoundException::new);

        playerFound.getJoinedTourneys().add(tourney);
        tourney.getPlayers().add(playerFound);

        return userAccountRepository.save(playerFound).entityToDto();

      
    public UserAccountResponseDto getUserByEmail(String email){
        Optional<UserAccount> userAppOptional = userAccountRepository.findByEmail(email);
        if(userAppOptional.isPresent()){
            return userAppOptional.get().entityToDto();
        }
        throw new NotFoundException();
    }

    public RegisterResponseDto registerUtilisateur(RegisterRequestDto registerRequestDto) throws UserAlreadyExistException {
        Optional<UserAccount> userAppOptional = userAccountRepository.findByEmail(registerRequestDto.getEmail());
        if(userAppOptional.isEmpty()){
            UserAccount user = UserAccount.builder()
                    .email(registerRequestDto.getEmail())
                    .username(registerRequestDto.getUsername())
                    .role((registerRequestDto.getRole()==0)? Role.USER : Role.ADMIN )
                    .password(registerRequestDto.getPassword()).build();
            return RegisterResponseDto.entityToDto(userAccountRepository.save(user));
        }
        throw new UserAlreadyExistException();

    }
}
