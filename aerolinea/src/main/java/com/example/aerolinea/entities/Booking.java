package com.example.aerolinea.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BookingStatus status;
    private Flight outboundFlight;
    private String  paymentToken;
    private boolean checkedIn;
    private User customer;
    private String createdAt;
    private String bookingReference;

    public Booking updatewith(Booking booking){
        return new Booking(this.id,
                           booking.getStatus(),
                           booking.getOutboundFlight(),
                           booking.getPaymentToken(),
                           booking.isCheckedIn(),
                           booking.getCustomer(),
                           booking.getCreatedAt(),
                           booking.getBookingReference());
    }
}
