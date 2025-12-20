package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class VerificationRequest {

    @Id
    @GeneratedValue
    private Long id;

    private Long credentialId;
    private String status;

    
}
