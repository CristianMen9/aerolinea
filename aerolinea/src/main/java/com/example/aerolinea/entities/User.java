package com.example.aerolinea.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String fullname;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public User updatewith(User user){
        return new User(this.id,
                        user.getFullname(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getBooking());
                        
    }

}
