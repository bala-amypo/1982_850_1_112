package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationRuleServiceImpl implements VerificationRuleService {

    @Autowired
    private VerificationRuleRepository repository;

    public VerificationRule createRule(VerificationRule rule) {
        return repository.save(rule);
    }

    public List<VerificationRule> getAllRules() {
        return repository.findAll();
    }

    public List<VerificationRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public VerificationRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public VerificationRule updateRule(Long id, VerificationRule rule) {
        VerificationRule existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setRuleCode(rule.getRuleCode());
            existing.setActive(rule.getActive());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}