package com.example.spring_security_demo.domain.dto;
import javax.validation.constraints.NotNull;

public record AutenticationRequest (
        @NotNull String username,
        @NotNull  String password) {
    public AutenticationRequest() {
        this(null, null);
    }
}
