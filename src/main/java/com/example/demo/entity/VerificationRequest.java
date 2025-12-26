package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "verification_requests")
public class VerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "credential_id")
    private CredentialRecord credential;

    public VerificationRequest() {
    }

  
    public VerificationRequest(Long id, String status, CredentialRecord credential) {
        this.id = id;
        this.status = status;
        this.credential = credential;
    }

  

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
}
