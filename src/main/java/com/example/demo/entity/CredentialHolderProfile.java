package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credential_holder_profiles")
public class CredentialHolderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String organization;

    @Column(nullable = false)
    private Boolean active = true;

    // Constructors
    public CredentialHolderProfile() {}

    public CredentialHolderProfile(String email, String organization) {
        this.email = email;
        this.organization = organization;
        this.active = true;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
