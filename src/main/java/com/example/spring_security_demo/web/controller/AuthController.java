package com.example.spring_security_demo.web.controller;

import com.example.spring_security_demo.domain.dto.AutenticationRequest;
import com.example.spring_security_demo.domain.dto.AutenticationResponse;
import com.example.spring_security_demo.domain.dto.CreateUserRequest;
import com.example.spring_security_demo.domain.dto.UserDto;
import com.example.spring_security_demo.domain.service.DemoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.time.Instant;
import java.util.stream.Collectors;

@RestController
// se le indica el path que le corresponde a este controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private DemoUserDetailsService userService;
    @Autowired
    private AuthenticationManager autenticationManager;
    @Autowired
    private JwtEncoder jwtEncoder;
    @PostMapping("/authenticate")
    public ResponseEntity<AutenticationResponse> createToken(@RequestBody @Valid AutenticationRequest request){
        try{
            Authentication authentication = autenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(),request.password()));
            UserDetails userDetails=(UserDetails)authentication.getPrincipal();
            var now = Instant.now();
            var expiry = 36000L;

            var scope =
                    authentication.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.joining(" "));

            var claims =
                    JwtClaimsSet.builder()
                            .issuer("example.io")
                            .issuedAt(now)
                            .expiresAt(now.plusSeconds(expiry))
                            .subject(String.format("%s", userDetails.getUsername()))
                            .claim("roles", scope)
                            .build();

            var token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

            return new ResponseEntity<>(new AutenticationResponse(token), HttpStatus.OK);
        }
        catch (BadCredentialsException exc){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid CreateUserRequest request) {
        try{
            return new ResponseEntity<>(userService.create(request), HttpStatus.OK);
        }catch (ValidationException exc){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
