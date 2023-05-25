package com.example.spring_security_demo.domain.dto;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public record UpdateUserAuthoritiesRequest(
        @NotNull Set<String> authorities) {
}
