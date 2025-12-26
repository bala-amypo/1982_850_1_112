package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuditTrailRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long credentialId;
    private LocalDateTime loggedAt;

    public AuditTrailRecord() {}

    public AuditTrailRecord(Long credentialId) {
        this.credentialId = credentialId;
        this.loggedAt = LocalDateTime.now();
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
