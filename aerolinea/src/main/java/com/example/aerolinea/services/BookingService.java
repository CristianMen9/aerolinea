package com.example.aerolinea.services;

import java.util.List;
import java.util.Optional;

import com.example.aerolinea.entities.Booking;

public interface BookingService {
    Booking create(Booking booking);
    Optional<Booking> update(Long id, Booking newBooking);
    List<Booking> findAll();
    Optional<Booking> findById(Long id);
    void deleteById(Long id);
}
