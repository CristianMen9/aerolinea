package com.example.aerolinea.exceptions;

public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException(){
        this("Flight not FOUND");
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
    
}
