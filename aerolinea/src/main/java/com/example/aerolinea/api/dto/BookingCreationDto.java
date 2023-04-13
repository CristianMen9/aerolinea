package com.example.aerolinea.api.dto;

import com.example.aerolinea.entities.BookingStatus;
import com.example.aerolinea.entities.Flight;
import com.example.aerolinea.entities.User;

import lombok.Data;

@Data
public class BookingCreationDto {
    private Long id;
    private BookingStatus status;
    private Flight outboundflight;
    private String paymenttoken;
    private boolean checkedin;
    private User customer;
    private String createdat;
    private String bookingreference;
    
}
