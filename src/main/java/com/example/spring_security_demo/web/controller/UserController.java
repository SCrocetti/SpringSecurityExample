package com.example.spring_security_demo.web.controller;

import com.example.spring_security_demo.domain.dto.*;
import com.example.spring_security_demo.domain.service.DemoUserDetailsService;
import com.example.spring_security_demo.persistance.entity.RoleName;
import com.example.spring_security_demo.persistance.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RolesAllowed({RoleName.USER_ADMIN})
// se le indica el path que le corresponde a este controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DemoUserDetailsService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody @Valid CreateUserRequest request) {
        try{
            return new ResponseEntity<>(userService.create(request), HttpStatus.OK);
        }catch (ValidationException exc){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_info/{id}")
    public ResponseEntity<UserDto> updateInfo(@PathVariable Integer id, @RequestBody @Valid UpdateUserInfoRequest request) {
        return new ResponseEntity<UserDto>(userService.updateInfo(id,request), HttpStatus.OK);
    }
    @PutMapping("/update_authorities/{id}")
    public ResponseEntity<UserDto> updateAuthorities(@PathVariable Integer id, @RequestBody @Valid UpdateUserAuthoritiesRequest request) {
        return new ResponseEntity<UserDto>(userService.updateAuthorities(id,request), HttpStatus.OK);
    }
    @PutMapping("/update_password/{id}")
    public ResponseEntity<UserDto> updatePassword(@PathVariable Integer id, @RequestBody @Valid UpdateUserPasswordRequest request) {
        try{
            return new ResponseEntity<UserDto>(userService.updatePassword(id,request), HttpStatus.OK);
        }catch (ValidationException exc){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto>  getUser(@PathVariable Integer id) {
        try{
            return new ResponseEntity<UserDto>(userService.findById(id), HttpStatus.OK);
        }catch (NotFoundException exc){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>>  getAll() {
        return new ResponseEntity<List<UserDto>>(userService.findAll(), HttpStatus.OK);
    }
}
