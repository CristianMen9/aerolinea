package com.example.aerolinea.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public User updatewith(User user){
        return new User(this.id,
                        user.getFullname(),
                        user.getUsername(),
                        user.getPassword());
    }

}
