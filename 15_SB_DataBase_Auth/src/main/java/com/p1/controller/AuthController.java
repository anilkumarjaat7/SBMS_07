package com.p1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p1.entity.Role;
import com.p1.entity.User;
import com.p1.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        user.setRole(Role.USER);

        user.setActive(true);

        userRepository.save(user);

        return ResponseEntity.ok(
                "User registered successfully"
        );
    }
}