package org.example.tournament.service;

import org.example.tournament.dto.userAccount.UserAccountReceiveDto;
import org.example.tournament.dto.userAccount.UserAccountResponseDto;
import org.example.tournament.entity.UserAccount;
import org.example.tournament.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import org.example.tournament.exception.NotFoundException;

import java.util.List;

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
        userAccountFound.setPassword(userAccountGet.getPassword());
        userAccountFound.setPp(userAccountGet.getPp());
        return userAccountRepository.save(userAccountFound).entityToDto();
    }

    public void delete(int id){
        userAccountRepository.deleteById(id);
    }
}
