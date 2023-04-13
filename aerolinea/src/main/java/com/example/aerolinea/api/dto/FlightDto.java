package com.example.aerolinea.api.dto;

import lombok.Data;

@Data
public class FlightDto {
    private String departureDate;
    private String departureAirportName;
    private String departureCity;
    private String departureLocale;
    private String arrivalCity;
    private String arrivalDate;
    private String arrivalAirportCode;
    private String arrivalAirportName;
    private String arrivalLocale;
    private int ticketPrice;
    private String ticketCurrency;
    private int flightNumber;
    private int seatCapacity;
    
}
