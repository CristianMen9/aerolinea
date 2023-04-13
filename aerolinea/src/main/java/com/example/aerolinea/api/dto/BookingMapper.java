package com.example.aerolinea.api.dto;

import org.springframework.stereotype.Component;

import com.example.aerolinea.entities.Booking;

@Component
public class BookingMapper {
    public BookingDto toDto(Booking booking){
        BookingDto bookingDto = new BookingDto();
        bookingDto.setStatus(booking.getStatus());
        bookingDto.setOutboundflight(booking.getOutboundFlight());
        bookingDto.setCustomer(booking.getCustomers());
        bookingDto.setPaymenttoken(booking.getPaymentToken());
        bookingDto.setCheckedin(booking.isCheckedIn());
        bookingDto.setCreatedat(booking.getCreatedAt());
        bookingDto.setBookingreference(booking.getBookingReference());

        return bookingDto;
    }

    public Booking toEntity(BookingDto bookingdto){
        Booking booking = new Booking();
        booking.setStatus(bookingdto.getStatus());
        booking.setOutboundFlight(bookingdto.getOutboundflight());
        booking.setCustomers(bookingdto.getCustomer());
        booking.setPaymentToken(bookingdto.getPaymenttoken());
        booking.setCheckedIn(bookingdto.isCheckedin());
        booking.setCreatedAt(bookingdto.getCreatedat());
        booking.setBookingReference(bookingdto.getBookingreference());

        return booking;
    }

    public BookingCreationDto toBookingCreationDto(Booking booking){
        BookingCreationDto bookingCreationDto = new BookingCreationDto();
        bookingCreationDto.setId(booking.getId());
        bookingCreationDto.setStatus(booking.getStatus());
        bookingCreationDto.setOutboundflight(booking.getOutboundFlight());
        bookingCreationDto.setCustomer(booking.getCustomers());
        bookingCreationDto.setPaymenttoken(booking.getPaymentToken());
        bookingCreationDto.setCheckedin(booking.isCheckedIn());
        bookingCreationDto.setCreatedat(booking.getCreatedAt());
        bookingCreationDto.setBookingreference(booking.getBookingReference());

        return bookingCreationDto;
    }

    public Booking toUserEntity(BookingCreationDto bookingCreationDto){
        Booking booking = new Booking();
        booking.setId(bookingCreationDto.getId());
        booking.setStatus(bookingCreationDto.getStatus());
        booking.setOutboundFlight(bookingCreationDto.getOutboundflight());
        booking.setCustomers(bookingCreationDto.getCustomer());
        booking.setPaymentToken(bookingCreationDto.getPaymenttoken());
        booking.setCheckedIn(bookingCreationDto.isCheckedin());
        booking.setCreatedAt(bookingCreationDto.getCreatedat());
        booking.setBookingReference(bookingCreationDto.getBookingreference());

        return booking;
    }


    
}
