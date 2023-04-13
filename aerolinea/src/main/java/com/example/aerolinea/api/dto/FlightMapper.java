package com.example.aerolinea.api.dto;

import org.springframework.stereotype.Component;

import com.example.aerolinea.entities.Flight;

@Component
public class FlightMapper {
    public FlightDto toDto(Flight flight){
        FlightDto flightDto = new FlightDto();
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setDepartureAirportName(flight.getDepartureAirportName());
        flightDto.setDepartureCity(flight.getDepartureCity());
        flightDto.setDepartureLocale(flight.getDepartureLocale());
        flightDto.setArrivalCity(flight.getArrivalCity());
        flightDto.setArrivalDate(flight.getArrivalDate());
        flightDto.setArrivalAirportCode(flight.getArrivalAirportCode());
        flightDto.setArrivalAirportName(flight.getArrivalAirportName());
        flightDto.setArrivalLocale(flight.getArrivalLocale());
        flightDto.setTicketPrice(flight.getTicketPrice());
        flightDto.setTicketCurrency(flight.getTicketCurrency());
        flightDto.setFlightNumber(flight.getFlightNumber());
        flightDto.setSeatCapacity(flight.getSeatCapacity());

        return flightDto;
    }

    public Flight toEntity(FlightDto flightdto){
        Flight flight = new Flight();
        flight.setDepartureDate(flightdto.getDepartureDate());
        flight.setDepartureAirportName(flightdto.getDepartureAirportName());
        flight.setDepartureCity(flightdto.getDepartureCity());
        flight.setDepartureLocale(flightdto.getDepartureLocale());
        flight.setArrivalCity(flightdto.getArrivalCity());
        flight.setArrivalDate(flightdto.getArrivalDate());
        flight.setArrivalAirportCode(flightdto.getArrivalAirportCode());
        flight.setArrivalAirportName(flightdto.getArrivalAirportName());
        flight.setArrivalLocale(flightdto.getArrivalLocale());
        flight.setTicketPrice(flightdto.getTicketPrice());
        flight.setTicketCurrency(flightdto.getTicketCurrency());
        flight.setFlightNumber(flightdto.getFlightNumber());
        flight.setSeatCapacity(flightdto.getSeatCapacity());

        return flight;
    }

    public FlightCreationDto toFlightCreationDto(Flight flight){
        FlightCreationDto flightCreationDto = new FlightCreationDto();
        flightCreationDto.setId(flight.getId());
        flightCreationDto.setDepartureDate(flight.getDepartureDate());
        flightCreationDto.setDepartureAirportName(flight.getDepartureAirportName());
        flightCreationDto.setDepartureCity(flight.getDepartureCity());
        flightCreationDto.setDepartureLocale(flight.getDepartureLocale());
        flightCreationDto.setArrivalCity(flight.getArrivalCity());
        flightCreationDto.setArrivalDate(flight.getArrivalDate());
        flightCreationDto.setArrivalAirportCode(flight.getArrivalAirportCode());
        flightCreationDto.setArrivalAirportName(flight.getArrivalAirportName());
        flightCreationDto.setArrivalLocale(flight.getArrivalLocale());
        flightCreationDto.setTicketPrice(flight.getTicketPrice());
        flightCreationDto.setTicketCurrency(flight.getTicketCurrency());
        flightCreationDto.setFlightNumber(flight.getFlightNumber());
        flightCreationDto.setSeatCapacity(flight.getSeatCapacity());

        return flightCreationDto;
    }

    public Flight toUserEntity(FlightCreationDto flightcreationdto){
        Flight flight = new Flight();
        flight.setId(flightcreationdto.getId());
        flight.setDepartureDate(flightcreationdto.getDepartureDate());
        flight.setDepartureAirportName(flightcreationdto.getDepartureAirportName());
        flight.setDepartureCity(flightcreationdto.getDepartureCity());
        flight.setDepartureLocale(flightcreationdto.getDepartureLocale());
        flight.setArrivalCity(flightcreationdto.getArrivalCity());
        flight.setArrivalDate(flightcreationdto.getArrivalDate());
        flight.setArrivalAirportCode(flightcreationdto.getArrivalAirportCode());
        flight.setArrivalAirportName(flightcreationdto.getArrivalAirportName());
        flight.setArrivalLocale(flightcreationdto.getArrivalLocale());
        flight.setTicketPrice(flightcreationdto.getTicketPrice());
        flight.setTicketCurrency(flightcreationdto.getTicketCurrency());
        flight.setFlightNumber(flightcreationdto.getFlightNumber());
        flight.setSeatCapacity(flightcreationdto.getSeatCapacity());

        return flight;
    } 
    
}
