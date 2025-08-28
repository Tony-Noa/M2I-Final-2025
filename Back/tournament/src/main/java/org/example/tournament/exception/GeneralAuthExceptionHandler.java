package org.example.tournament.exception;


import org.example.tournament.dto.security.LoginResponseDto;
import org.example.tournament.dto.security.RegisterResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralAuthExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<RegisterResponseDto> UserAlreadyExistHandler (UserAlreadyExistException ex){
        RegisterResponseDto registerResponseDto = new RegisterResponseDto(-1,"email","username","default.jpg",0);
        return new ResponseEntity<>(registerResponseDto, HttpStatus.OK);
    }


    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<LoginResponseDto> notFoundExceptionHandler (TokenNotFoundException ex){
        LoginResponseDto loginResponseDto = new LoginResponseDto(-1,"TokenNotFound");
        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    } // Faudra voir comment on puisse renvoyer dans le response (de postman par exemple) le {"id": -1, "token": "TokenNotFound"}
}
