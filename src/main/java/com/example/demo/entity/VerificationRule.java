package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Objects;

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

    @Column(nullable = false)
    private Boolean active = true;

    // Default constructor required by JPA
    public VerificationRule() {
    }

    // Constructor for tests or convenience
    public VerificationRule(Long id, String ruleCode, Boolean active) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.active = active;
    }

    // ---------- Getters & Setters ----------

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

    // ---------- Optional: equals, hashCode, toString ----------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationRule)) return false;
        VerificationRule that = (VerificationRule) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "VerificationRule{" +
                "id=" + id +
                ", ruleCode='" + ruleCode + '\'' +
                ", active=" + active +
                '}';
    }
}
