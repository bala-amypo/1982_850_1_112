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
    private Long userId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    @PrePersist
    protected void onCreate() { this.loggedAt = LocalDateTime.now(); }

    // Constructors
    public AuditTrailRecord() {}
    public AuditTrailRecord(Long userId) { this.userId = userId; }

    // Getters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
}
