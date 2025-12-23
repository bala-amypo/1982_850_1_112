package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for Swagger and testing purposes
            .csrf(csrf -> csrf.disable())

            // Configure endpoint authorization
            .authorizeHttpRequests(auth -> auth
                // Permit Swagger/OpenAPI endpoints
                .requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/swagger-ui/index.html"
                ).permitAll()
                
                // Permit auth endpoints
                .requestMatchers("/auth/**").permitAll()
                
                // All other requests require authentication
                .anyRequest().authenticated()
            )

            // Optional: use HTTP Basic for testing (can replace with JWT)
            .httpBasic();

        return http.build();
    }
}
