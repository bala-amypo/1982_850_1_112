package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

public class CredentialRecord {
    private String credentialCode;
    private String title;
    private String credentialType;
    private String issuer;
    private LocalDate expiryDate;
    private String status;
    private Long holderId;
    private String metadataJson;

    // getters
    public String getCredentialCode() { return credentialCode; }
    public String getTitle() { return title; }
    public String getCredentialType() { return credentialType; }
    public String getIssuer() { return issuer; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getStatus() { return status; }
    public Long getHolderId() { return holderId; }
    public String getMetadataJson() { return metadataJson; }

    // setters
    public void setCredentialCode(String credentialCode) { this.credentialCode = credentialCode; }
    public void setTitle(String title) { this.title = title; }
    public void setCredentialType(String credentialType) { this.credentialType = credentialType; }
    public void setIssuer(String issuer) { this.issuer = issuer; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public void setStatus(String status) { this.status = status; }
    public void setHolderId(Long holderId) { this.holderId = holderId; }
    public void setMetadataJson(String metadataJson) { this.metadataJson = metadataJson; }
}
