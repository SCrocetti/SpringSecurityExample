package com.example.spring_security_demo.domain.dto;

import javax.validation.constraints.NotBlank;

public record UpdateUserPasswordRequest (
        @NotBlank String oldPassword,
        @NotBlank String newPassword,
        @NotBlank String reNewPassword){
}
