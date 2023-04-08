package com.example.aerolinea.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking")
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

    @OneToMany(mappedBy = "usuarios")
    private Set<User> customers;
    
    private String createdAt;
    private String bookingReference;

    public Booking updatewith(Booking booking){
        return new Booking(this.id,
                           booking.getStatus(),
                           booking.getOutboundFlight(),
                           booking.getPaymentToken(),
                           booking.isCheckedIn(),
                           booking.getCustomers(),
                           booking.getCreatedAt(),
                           booking.getBookingReference());
    }
}
