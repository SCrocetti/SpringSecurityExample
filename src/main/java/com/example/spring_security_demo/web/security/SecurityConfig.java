package com.example.spring_security_demo.web.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    // this configures the AuthManager with the correct provider
    // esto configura el AuthManager con el proveedor correcto
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO configure authentication manager
    }

    @Override
    // this configures Web security
    // esto configura la seguridad web
    protected void configure(HttpSecurity http) throws Exception {
        // TODO configure web security
    }

}