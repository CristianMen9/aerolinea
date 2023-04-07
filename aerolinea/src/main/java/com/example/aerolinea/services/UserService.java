package com.example.aerolinea.services;

import java.util.List;
import java.util.Optional;

import com.example.aerolinea.entities.User;

public interface UserService {
    User create(User user);
    Optional<User> update(Long id, User newUser);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
}
