package com.example.demo.entity;

import java.util.Set;

public class CredentialRecord {
    private Long id;
    private Long holderId;
    private String code;
    private Set<VerificationRule> rules;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getHolderId() { return holderId; }
    public void setHolderId(Long holderId) { this.holderId = holderId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Set<VerificationRule> getRules() { return rules; }
    public void setRules(Set<VerificationRule> rules) { this.rules = rules; }
}
