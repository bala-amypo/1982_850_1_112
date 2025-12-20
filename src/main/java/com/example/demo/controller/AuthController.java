package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController<AuthenticationManager> {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(
            UserService userService,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil) {

        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

   
    @PostMapping("/register")
public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {

    User user = new User();
    user.setFullname(request.getFullName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword())); 
    user.setRole(request.getRole());

    User savedUser = userService.registerUser(user);

    String token = jwtUtil.generateToken(
            savedUser.getId(),
            savedUser.getEmail(),
            savedUser.getRole()
    );

    JwtResponse response = new JwtResponse(
            token,
            savedUser.getId(),
            savedUser.getEmail(),
            savedUser.getRole()
    );

    return ResponseEntity.ok(response);
}

}
