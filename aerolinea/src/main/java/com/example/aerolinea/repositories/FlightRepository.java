package com.example.aerolinea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aerolinea.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    
}
