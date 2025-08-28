package org.example.tournament.exception;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException() {
        super("User Already Exist");
    } // Pour éviter les doublons
}
