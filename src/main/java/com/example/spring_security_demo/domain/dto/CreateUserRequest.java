package com.example.spring_security_demo.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public record CreateUserRequest (
        @NotBlank String username,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotBlank String rePassword,
        Set<String> authorities) {
        public CreateUserRequest {
            if (authorities == null) {
                authorities = new HashSet<>();
            }
        }

        public CreateUserRequest(
                String username,
                String firstName,
                String lastName,
                String email,
                String password,
                String rePassword
        ) {
            this(username, firstName,lastName,email, password, rePassword, new HashSet<>());
        }

        public CreateUserRequest(
                String username,
                String firstName,
                String lastName,
                String email,
                String password
        ) {
            this(username,firstName,lastName,email, password, password, new HashSet<>());
        }

}
