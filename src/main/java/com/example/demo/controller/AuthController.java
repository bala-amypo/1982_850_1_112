package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User saved = userService.registerUser(user);
        return ResponseEntity.ok(
                jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole())
        );
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(), user.getPassword()
                )
        );

        User found = userService.getUserByEmail(user.getEmail());
        return ResponseEntity.ok(
                jwtUtil.generateToken(found.getId(), found.getEmail(), found.getRole())
        );
    }
}
