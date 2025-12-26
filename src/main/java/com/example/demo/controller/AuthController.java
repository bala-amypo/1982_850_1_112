package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.Role;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;

import jakarta.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userService.getRolesFromNames(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet())));
        User saved = userService.registerUser(user);
        return ResponseEntity.ok("User registered: " + saved.getEmail());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid credentials");
        }
        User dbUser = userService.findByEmail(user.getEmail());
        String token = jwtUtil.generateToken(dbUser.getId(), dbUser.getEmail(),
                dbUser.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        return ResponseEntity.ok(token);
    }
}
