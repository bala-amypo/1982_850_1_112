package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;

import java.util.Set;

public interface UserService {

    AuthResponse login(AuthRequest request);

    User registerUser(String email, String password, Set<String> roles);

    User findByEmail(String email);
}
