package com.p1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public String users() {

        return "User API - Authentication Successful";
    }

    @GetMapping("/admin")
    public String admin() {

        return "Admin API - Authentication Successful";
    }
}
