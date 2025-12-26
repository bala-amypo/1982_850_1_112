package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "verification_rule",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "ruleCode")
    }
)
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    // ✅ Default value required by tests
    @Column(nullable = false)
    private Boolean active = true;

    // ✅ JPA required
    public VerificationRule() {
    }

    // ✅ Required by tests
    public VerificationRule(Long id, String ruleCode, Boolean active) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.active = active;
    }

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
