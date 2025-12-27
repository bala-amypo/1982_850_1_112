package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String credentialCode;

    private String credentialTitle; // <-- make sure this exists
    private String credentialType;
    private String issuer;
    private Date expiryDate;
    private String status;
    private Long holderId;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCredentialCode() { return credentialCode; }
    public void setCredentialCode(String credentialCode) { this.credentialCode = credentialCode; }

    public String getCredentialTitle() { return credentialTitle; } // <-- this must exist
    public void setCredentialTitle(String credentialTitle) { this.credentialTitle = credentialTitle; }

    public String getCredentialType() { return credentialType; }
    public void setCredentialType(String credentialType) { this.credentialType = credentialType; }

    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getHolderId() { return holderId; }
    public void setHolderId(Long holderId) { this.holderId = holderId; }

    // add other fields if needed
}
