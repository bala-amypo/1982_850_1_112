package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@GetMapping("/user/{email}")
public User getUser(@PathVariable String email) {
    return service.findByEmail(email)
                  .orElse(null); // safely unwrap Optional<User>
}

public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User existing = service.findByEmail(user.getEmail());
        if (existing != null && existing.getPassword().equals(user.getPassword())) {
            return existing;
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
