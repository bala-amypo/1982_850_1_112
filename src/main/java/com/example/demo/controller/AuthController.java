package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, Object> request) {

        String name = (String) request.get("name");
        String email = (String) request.get("email");
        String password = (String) request.get("password");

        @SuppressWarnings("unchecked")
        Set<String> roles = (Set<String>) request.get("roles");

        userService.registerUser(email, password, roles);

        return ResponseEntity.ok("User registered successfully");
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        String token = userService.login(email, password);

        return ResponseEntity.ok(Map.of(
                "token", token,
                "type", "Bearer"
        ));
    }
}
