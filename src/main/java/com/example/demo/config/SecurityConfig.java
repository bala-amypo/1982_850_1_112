package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for APIs
            .csrf(csrf -> csrf.disable())

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Public endpoints (Swagger & Auth)
                .requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/auth/**"
                ).permitAll()
                
                // All other endpoints require authentication
                .anyRequest().authenticated()
            )

            // Disable default HTTP Basic pop-up for Swagger
            .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }

    // Expose AuthenticationManager for AuthController
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // Password encoder for user authentication
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
