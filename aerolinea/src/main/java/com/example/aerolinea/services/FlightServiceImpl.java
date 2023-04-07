package com.example.aerolinea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.aerolinea.entities.Flight;
import com.example.aerolinea.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService  {
    private final FlightRepository flightRepository;

    

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight create(Flight flight) {
        Flight copy = new Flight(flight.getId(),
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
        return flightRepository.save(copy);                         
    }

    @Override
    public Optional<Flight> update(Long id, Flight newFlight) {
        return flightRepository.findById(id)
                .map(f -> {
                    Flight flight = f.updatewith(newFlight);
                    return flightRepository.save(flight);
                });
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }
    
}
