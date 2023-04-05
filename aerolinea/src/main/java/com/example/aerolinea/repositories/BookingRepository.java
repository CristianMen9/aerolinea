package com.example.aerolinea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aerolinea.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
