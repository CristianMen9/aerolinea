package com.example.aerolinea.api.dto;

import lombok.Data;

@Data
public class UserCreationDto {
    private Long id;
    private String fullname;
    private String username;
    private String password;
}
