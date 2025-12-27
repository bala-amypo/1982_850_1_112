package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
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
    private Long holderId;
    
    @Lob
    private String metadataJson;

    @ElementCollection
    private List<String> rules;

    // Getters
    public Long getId() { return id; }
    public String getCredentialCode() { return credentialCode; }
    public String getTitle() { return title; }
    public String getCredentialType() { return credentialType; }
    public String getIssuer() { return issuer; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getStatus() { return status; }
    public Long getHolderId() { return holderId; }
    public String getMetadataJson() { return metadataJson; }
    public List<String> getRules() { return rules; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setCredentialCode(String credentialCode) { this.credentialCode = credentialCode; }
    public void setTitle(String title) { this.title = title; }
    public void setCredentialType(String credentialType) { this.credentialType = credentialType; }
    public void setIssuer(String issuer) { this.issuer = issuer; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public void setStatus(String status) { this.status = status; }
    public void setHolderId(Long holderId) { this.holderId = holderId; }
    public void setMetadataJson(String metadataJson) { this.metadataJson = metadataJson; }
    public void setRules(List<String> rules) { this.rules = rules; }
}
