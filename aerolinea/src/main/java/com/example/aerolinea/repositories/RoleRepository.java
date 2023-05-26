package com.example.aerolinea.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aerolinea.entities.ERole;
import com.example.aerolinea.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
    
}
