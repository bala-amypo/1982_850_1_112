package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public JwtResponse register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        return new JwtResponse(jwtUtil.generateToken(1L, user.getEmail(), user.getRole()),
                1L, user.getEmail(), user.getRole());
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");
        return new JwtResponse(jwtUtil.generateToken(1L, user.getEmail(), user.getRole()),
                1L, user.getEmail(), user.getRole());
    }
}
