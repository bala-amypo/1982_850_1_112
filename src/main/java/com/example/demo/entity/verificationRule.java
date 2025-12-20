package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CredentialHolderProfile {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String organization;
    private Boolean active;

   
}
