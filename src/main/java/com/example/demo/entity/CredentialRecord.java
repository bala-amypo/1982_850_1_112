package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "credential_record")
public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String credentialCode;
    private String title;
    private String credentialType;
    private String issuer;
    private LocalDate expiryDate;
    private String status;

    @ManyToMany
    @JoinTable(
        name = "credential_holder_records",
        joinColumns = @JoinColumn(name = "credential_id"),
        inverseJoinColumns = @JoinColumn(name = "holder_id")
    )
    private Set<CredentialHolderProfile> holders;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCredentialCode() { return credentialCode; }
    public void setCredentialCode(String credentialCode) { this.credentialCode = credentialCode; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCredentialType() { return credentialType; }
    public void setCredentialType(String credentialType) { this.credentialType = credentialType; }

    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Set<CredentialHolderProfile> getHolders() { return holders; }
    public void setHolders(Set<CredentialHolderProfile> holders) { this.holders = holders; }
}
