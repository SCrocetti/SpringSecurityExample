package com.example.spring_security_demo.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

// carries only the not sensible info
public record UpdateUserInfoRequest (
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email){
        public UpdateUserInfoRequest() {
            this(null, null,null);
        }
}
