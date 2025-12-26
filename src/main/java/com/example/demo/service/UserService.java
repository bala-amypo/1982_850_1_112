package com.example.demo.service;

import java.util.Set;

public interface UserService {

    String login(String email, String password);

    void registerUser(String email, String password, Set<String> roles);
}
