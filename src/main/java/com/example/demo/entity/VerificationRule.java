package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private boolean active;

    // Getters
    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public boolean getActive() { return active; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public void setActive(boolean active) { this.active = active; }
}
