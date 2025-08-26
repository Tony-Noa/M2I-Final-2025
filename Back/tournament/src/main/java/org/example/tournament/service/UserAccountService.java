package org.example.tournament.service;

import org.example.tournament.dto.security.RegisterRequestDto;
import org.example.tournament.dto.userAccount.UserAccountReceiveDto;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;
import org.example.tournament.entity.Tourney;
import org.example.tournament.entity.UserAccount;
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

    public UserAccountService(UserAccountRepository userAccountRepository){
        this.userAccountRepository = userAccountRepository;
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

    public UserAccountResponseDto update(int id, UserAccountReceiveDto UserAccountReceiveDto){
        UserAccount userAccountFound = userAccountRepository.findById(id).orElseThrow(NotFoundException::new);
        UserAccount userAccountGet = UserAccountReceiveDto.dtoToEntity();
        userAccountFound.setUsername(userAccountGet.getUsername());
        userAccountFound.setPp(userAccountGet.getPp());
        return userAccountRepository.save(userAccountFound).entityToDto();
    }

    public void delete(int id){
        userAccountRepository.deleteById(id);
    }

    public UserAccount enregistrerUtilisateur(RegisterRequestDto registerRequestDto) throws UserAlreadyExistException {
        Optional<UserAccount> userAppOptional = userAccountRepository.findByEmail(registerRequestDto.getEmail());
        if(userAppOptional.isEmpty()){
            UserAccount user = UserAccount.builder().email(registerRequestDto.getEmail())
                    .username(registerRequestDto.getUsername())
                    .role((registerRequestDto.getRole()==0)? Role.USER : Role.ADMIN )
                    .pp(RegisterRequestDto.get()).build();
            return userAccountRepository.save(user);
        }
        throw new UserAlreadyExistException();
    }
}
