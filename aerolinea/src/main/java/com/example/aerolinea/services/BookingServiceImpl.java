package com.example.aerolinea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.aerolinea.entities.Booking;
import com.example.aerolinea.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking create(Booking booking) {
        Booking copy = new Booking(booking.getId(),
                                   booking.getStatus(),
                                   booking.getOutboundFlight(),
                                   booking.getPaymentToken(),
                                   booking.isCheckedIn(),
                                   booking.getCustomers(),
                                   booking.getCreatedAt(),
                                   booking.getBookingReference());
        return bookingRepository.save(copy);                           
    }

    @Override
    public Optional<Booking> update(Long id, Booking newBooking) {
        return bookingRepository.findById(id)
                .map(b -> {
                    Booking booking = b.updatewith(newBooking);
                    return bookingRepository.save(booking);
                });
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }
    
}
