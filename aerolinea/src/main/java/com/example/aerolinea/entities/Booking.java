package com.example.aerolinea.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    private Long id;
    private BookingStatus status;
    private Flight outboundFlight;
    private String  paymentToken;
    private boolean checkedIn;
    private User customer;
    private String createdAt;
    private String bookingReference;
}
