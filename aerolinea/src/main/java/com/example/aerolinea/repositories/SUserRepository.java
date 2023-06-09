package com.example.aerolinea.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aerolinea.entities.SUser;

public interface SUserRepository extends JpaRepository<SUser,Long> {
    Optional<SUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
}
