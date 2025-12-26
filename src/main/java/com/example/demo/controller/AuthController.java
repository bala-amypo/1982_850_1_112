package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam(required = false) Set<String> roles) {

        if (roles == null || roles.isEmpty()) {
            roles = Set.of("ROLE_USER"); // default role
        }

        return userService.registerUser(username, password, roles);
    }
}
