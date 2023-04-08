package com.example.aerolinea.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aerolinea.api.dto.UserCreationDto;
import com.example.aerolinea.api.dto.UserDto;
import com.example.aerolinea.api.dto.UserMapper;
import com.example.aerolinea.entities.User;
import com.example.aerolinea.exceptions.DuplicateCodigoException;
import com.example.aerolinea.exceptions.UserNotFoundException;
import com.example.aerolinea.services.UserService;

@RestController
@RequestMapping("/aerolinea/v1")
public class UserController {
    private final UserService userservice;
    private final UserMapper usermapper;


    public UserController(UserService userservice, UserMapper usermapper) {
        this.userservice = userservice;
        this.usermapper = usermapper;
    }

    @GetMapping("/users/")
    public ResponseEntity<List<UserCreationDto>> findAll(){
        List<User> users = userservice.findAll();
        List<UserCreationDto> usercreationdtos = users.stream()
                                           .map(u -> usermapper.toUserCreationDto(u))
                                           .collect(Collectors.toList());
        return ResponseEntity.ok().body(usercreationdtos);                                   
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserCreationDto> findById(@PathVariable("id") Long id){
        UserCreationDto user = userservice.findById(id)
                 .map(u -> usermapper.toUserCreationDto(u))
                 .orElseThrow(UserNotFoundException :: new);
        return ResponseEntity.status(HttpStatus.FOUND).body(user);         
    }

    @PostMapping("/users")
    public ResponseEntity<UserCreationDto> create(@RequestBody UserDto user){

        User newUser = usermapper.toEntity(user);
        User usercreated = null;

        try{
            usercreated = userservice.create(newUser);

        } catch(Exception e){
            throw new DuplicateCodigoException();
        }

        UserCreationDto usercreationdto = usermapper.toUserCreationDto(usercreated);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(usercreationdto.getId())
                        .toUri();
        return ResponseEntity.created(location).body(usercreationdto);                
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserCreationDto> update(@PathVariable("id") Long id, @RequestBody UserCreationDto user){
        User usertoupdate = usermapper.toUserEntity(user);
        return userservice.update(id, usertoupdate)
                 .map(u -> ResponseEntity.ok().body(usermapper.toUserCreationDto(usertoupdate)))
                 .orElseGet(() -> {
                    UserCreationDto usercreationdto = usermapper.toUserCreationDto(usertoupdate);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                          .path("/{id}")
                                          .buildAndExpand(usercreationdto.getId())
                                          .toUri();
                    return ResponseEntity.created(location).body(usercreationdto);                       
                 });
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Long id){
        userservice.deleteById(id);
    }
    
    
}
