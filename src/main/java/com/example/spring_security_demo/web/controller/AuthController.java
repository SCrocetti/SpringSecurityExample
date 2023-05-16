package com.example.spring_security_demo.web.controller;

import com.example.spring_security_demo.domain.dto.AutenticationRequest;
import com.example.spring_security_demo.domain.dto.AutenticationResponse;
import com.example.spring_security_demo.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// se le indica el path que le corresponde a este controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager autenticationManager;
    @Autowired
    private JWTUtil util;
    @PostMapping("/authenticate")
    public ResponseEntity<AutenticationResponse> createToken(@RequestBody AutenticationRequest request){
        try{
            Authentication autentication = autenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            UserDetails userDetails=(UserDetails)autentication.getPrincipal();
            String jwt=util.generateToken(userDetails);
            return new ResponseEntity<>(new AutenticationResponse(jwt), HttpStatus.OK);
        }
        catch (BadCredentialsException exc){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
