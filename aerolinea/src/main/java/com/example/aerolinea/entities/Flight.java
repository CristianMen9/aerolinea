package com.example.aerolinea.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vuelos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
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

    public Flight updatewith(Flight flight){
        return new Flight(this.id,
                          flight.getDepartureDate(),
                          flight.getDepartureAirportName(),
                          flight.getDepartureCity(),
                          flight.getDepartureLocale(),
                          flight.getArrivalCity(),
                          flight.getArrivalDate(),
                          flight.getArrivalAirportCode(),
                          flight.getArrivalAirportName(),
                          flight.getArrivalLocale(),
                          flight.getTicketPrice(),
                          flight.getTicketCurrency(),
                          flight.getFlightNumber(),
                          flight.getSeatCapacity());
    }
}
