package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_trail")
public class AuditTrailRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long credentialId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    // Automatically set timestamp before insert
    @PrePersist
    protected void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    // Constructors
    public AuditTrailRecord() {}

    public AuditTrailRecord(Long credentialId) {
        this.credentialId = credentialId;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}
