package com.example.aerolinea.api.dto;

import org.springframework.stereotype.Component;

import com.example.aerolinea.entities.User;

@Component
public class UserMapper {
    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setFullname(user.getFullname());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public User toEntity(UserDto userdto){
        User user = new User();
        user.setFullname(userdto.getFullname());
        user.setUsername(userdto.getUsername());
        user.setPassword(userdto.getPassword());

        return user;
    }

    public UserCreationDto toUserCreationDto(User user){
        UserCreationDto userCreationDto = new UserCreationDto();
        userCreationDto.setId(user.getId());
        userCreationDto.setFullname(user.getFullname());
        userCreationDto.setUsername(user.getUsername());
        userCreationDto.setPassword(user.getPassword());

        return userCreationDto;
    }

    public User toUserEntity(UserCreationDto usercreationdto){
        User user = new User();
        user.setId(usercreationdto.getId());
        user.setFullname(usercreationdto.getFullname());
        user.setUsername(usercreationdto.getUsername());
        user.setPassword(usercreationdto.getPassword());

        return user;
    }
}
