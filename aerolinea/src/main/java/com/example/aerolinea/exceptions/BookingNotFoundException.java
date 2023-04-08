package com.example.aerolinea.exceptions;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(){
        this("Booking not FOUND");
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
    
}
