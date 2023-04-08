package com.example.aerolinea.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){
        this("User not FOUND");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
    
}
