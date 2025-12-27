package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(Long id, String email, String role) {
        return "TOKEN";
    }

    public String getUsernameFromToken(String token) {
        return "user@test.com";
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return true;
    }
}
