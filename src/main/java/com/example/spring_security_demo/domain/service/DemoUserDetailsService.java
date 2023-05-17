package com.example.spring_security_demo.domain.service;

import com.example.spring_security_demo.persistance.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCrudRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
                .findByUsername(username)
                .orElseThrow(
                        () ->
                                new UsernameNotFoundException(
                                        String.format("User with username - %s, not found", username)));
    }
}
