package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")  // Base path for all endpoints
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    // Get user by email
    @GetMapping("/user/{email}")
    public User getUser(@PathVariable String email) {
        Optional<User> optionalUser = service.findByEmail(email);
        return optionalUser.orElse(null);  // safely unwrap Optional<User>
    }

    // Register new user
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.save(user);
    }

    // Login user
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        Optional<User> optionalUser = service.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            User existing = optionalUser.get();
            if (existing.getPassword().equals(user.getPassword())) {
                return existing;
            }
        }
        throw new RuntimeException("Invalid credentials");
    }
}
