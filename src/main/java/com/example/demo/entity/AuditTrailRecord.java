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

    @Column(nullable = false)
    private Long userId;  // User performing the action

    @Column(nullable = false)
    private String roleName; // Role of the user performing the action

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    // Automatically set timestamp before insert
    @PrePersist
    protected void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    // Constructors
    public AuditTrailRecord() {}

    public AuditTrailRecord(Long credentialId, Long userId, String roleName) {
        this.credentialId = credentialId;
        this.userId = userId;
        this.roleName = roleName;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}
