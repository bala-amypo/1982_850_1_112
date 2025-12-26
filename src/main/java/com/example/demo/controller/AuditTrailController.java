package com.example.demo.controller;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditTrailController {

    private final AuditTrailService auditService;

    public AuditTrailController(AuditTrailService auditService) {
        this.auditService = auditService;
    }

    @PostMapping
    public AuditTrailRecord logEvent(@RequestBody AuditTrailRecord record) {
        return auditService.logEvent(record);
    }

    @GetMapping("/{credentialId}")
    public List<AuditTrailRecord> getLogs(@PathVariable Long credentialId) {
        return auditService.getLogsByCredential(credentialId);
    }
}
