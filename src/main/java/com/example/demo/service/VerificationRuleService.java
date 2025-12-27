package com.example.demo.service;

import com.example.demo.entity.VerificationRule;
import java.util.List;

public interface VerificationRuleService {
    VerificationRule createRule(VerificationRule rule);
    List<VerificationRule> getAllRules();
    List<VerificationRule> getActiveRules();
    VerificationRule getRuleById(Long id);
    VerificationRule updateRule(Long id, VerificationRule rule);
    void deleteRule(Long id);
}
