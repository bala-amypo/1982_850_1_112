package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuditTrailRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long credentialId;
    private LocalDateTime loggedAt;

    // getters and setters
}
