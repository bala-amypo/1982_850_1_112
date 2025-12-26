package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "verification_requests")
public class VerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id", nullable = false)
    private CredentialRecord credential;

    // Default constructor for JPA
    public VerificationRequest() {
    }

    // Constructor with fields
    public VerificationRequest(Long id, String status, CredentialRecord credential) {
        this.id = id;
        this.status = status;
        this.credential = credential;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CredentialRecord getCredential() {
        return credential;
    }

    public void setCredential(CredentialRecord credential) {
        this.credential = credential;
    }

    // Optional: Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationRequest)) return false;
        VerificationRequest that = (VerificationRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Optional: toString
    @Override
    public String toString() {
        return "VerificationRequest{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", credential=" + (credential != null ? credential.getId() : null) +
                '}';
    }
}
