package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        String token = userService.login(email, password);

        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> request) {

        String email = (String) request.get("email");
        String password = (String) request.get("password");

        // roles example: ["ROLE_USER"]
        @SuppressWarnings("unchecked")
        var roles = (java.util.List<String>) request.get("roles");

        userService.registerUser(email, password, new java.util.HashSet<>(roles));

        return ResponseEntity.ok("User registered successfully");
    }
}
