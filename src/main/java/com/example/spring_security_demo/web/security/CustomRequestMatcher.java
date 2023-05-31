package com.example.spring_security_demo.web.security;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class CustomRequestMatcher implements RequestMatcher {
    private static final Pattern ALLOWED_METHODS = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

    @Override
    public boolean matches(HttpServletRequest request) {
        // Exclude /auth/authenticate from CSRF protection
        if ("/auth/authenticate".equals(request.getRequestURI())) {
            return false;
        }

        // Exclude allowed methods from CSRF protection
        String method = request.getMethod();
        return !ALLOWED_METHODS.matcher(method).matches();
    }
}