package com.example.aerolinea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.aerolinea.entities.User;
import com.example.aerolinea.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        User copy = new User(user.getId(),
                             user.getFullname(),
                             user.getUsername(),
                             user.getPassword());
        return userRepository.save(copy);                     
    }

    @Override
    public Optional<User> update(Long id, User newUser) {
        return userRepository.findById(id)
                .map(u -> {
                    User user = u.updatewith(newUser);
                    return userRepository.save(user);
                });
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    
}
