package com.example.spring_security_demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @GetMapping("user")
    public String helloUser() {
        return "Hello User";
    }
}
