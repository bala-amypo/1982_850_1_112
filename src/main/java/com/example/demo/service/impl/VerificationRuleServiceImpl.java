package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationRuleServiceImpl implements VerificationRuleService {

    private final VerificationRuleRepository repository;

    public VerificationRuleServiceImpl(VerificationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public VerificationRule createRule(VerificationRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<VerificationRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<VerificationRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public VerificationRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public VerificationRule updateRule(Long id, VerificationRule rule) {
        VerificationRule existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setRuleCode(rule.getRuleCode());
            existing.setActive(rule.getActive());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
