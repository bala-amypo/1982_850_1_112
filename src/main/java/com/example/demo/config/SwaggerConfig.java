package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Swagger {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        
                        .servers(List.of(
                        new Server().url("https://9015")
                ));
        }
}