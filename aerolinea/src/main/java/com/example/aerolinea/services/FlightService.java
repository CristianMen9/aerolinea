package com.example.aerolinea.services;

import java.util.List;
import java.util.Optional;

import com.example.aerolinea.entities.Flight;

public interface FlightService {
    Flight create(Flight flight);
    Optional<Flight> update(Long id, Flight newFlight);
    List<Flight> findAll();
    Optional<Flight> findById(Long id);
    void deleteById(Long id);
}
