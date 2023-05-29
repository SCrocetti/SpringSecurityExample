package com.example.spring_security_demo.domain.dto;

import java.util.Set;

public record  UserDto (
        Integer userId,
        String username,
        String firstName,
        String lastName,
        String email){
}
