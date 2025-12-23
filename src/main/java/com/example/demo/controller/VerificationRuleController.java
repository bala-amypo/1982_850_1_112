package com.example.demo.controller;

import com.example.demo.dto.VerificationRuleRequest;
import com.example.demo.entity.VerificationRule;
import com.example.demo.service.VerificationRuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class VerificationRuleController {

    private final VerificationRuleService ruleService;

    public VerificationRuleController(VerificationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public ResponseEntity<VerificationRule> create(@Valid @RequestBody VerificationRuleRequest requestDto) {
        VerificationRule rule = new VerificationRule();
        rule.setName(requestDto.getName());
        rule.setDescription(requestDto.getDescription());
        rule.setCondition(requestDto.getCondition());

        VerificationRule created = ruleService.createRule(rule);
        return ResponseEntity.ok(created);
    }
}
