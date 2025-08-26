package org.example.tournament.controller;

import org.example.tournament.dto.security.LoginRequestDto;
import org.example.tournament.dto.security.LoginResponseDto;
import org.example.tournament.dto.security.RegisterRequestDto;
import org.example.tournament.dto.security.RegisterResponseDto;
import org.example.tournament.entity.UserAccount;
import org.example.tournament.exception.NotFoundException;
import org.example.tournament.exception.UserAlreadyExistException;
import org.example.tournament.security.JWTGenerator;
import org.example.tournament.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserAuthController {

    private final AuthenticationManager authenticationManager;
    private final UserAccountService userAccountService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public UserAppController(AuthenticationManager authenticationManager, UserAccountService userAccountService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.userAccountService = userAccountService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }


    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDTO) throws NotFoundException {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(LoginResponseDto.builder().token(generator.generateToken(authentication)).build());
        }catch (Exception ex) {
            throw new NotFoundException();
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDTO) throws UserAlreadyExistException {
        registerRequestDTO.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        UserAccount userApp = userAccountService.enregistrerUtilisateur(registerRequestDTO);
        return ResponseEntity.ok(RegisterResponseDto.builder().id(userApp.getId_user()).email(userApp.getEmail()).lastname(userApp.getLastname()).firstname(userApp.getFirstname()).phone(userApp.getPhone()).role(userApp.getRole().ordinal()).build());
    }
}
