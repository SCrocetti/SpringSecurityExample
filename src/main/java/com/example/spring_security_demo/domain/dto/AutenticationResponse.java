package com.example.spring_security_demo.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record AutenticationResponse(
        @NotBlank String jwt) {
    public AutenticationResponse(){
        this("");
    }
}
