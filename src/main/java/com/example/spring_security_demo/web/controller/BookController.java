package com.example.spring_security_demo.web.controller;

import com.example.spring_security_demo.persistance.entity.RoleName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RolesAllowed({RoleName.BOOK_ADMIN})
@RequestMapping("/books")
public class BookController {
    @GetMapping("/all")
    public String helloUser() {
        return "Hello User";
    }
}
