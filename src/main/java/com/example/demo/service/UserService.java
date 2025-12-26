package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import java.util.Set;

public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);
    Set<Role> getRolesFromNames(Set<String> roleNames);
}
