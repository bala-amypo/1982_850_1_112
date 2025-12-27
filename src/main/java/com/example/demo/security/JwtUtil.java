package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public String generateToken(Long id, String email, String role) {
        return "TOKEN";
    }
}
