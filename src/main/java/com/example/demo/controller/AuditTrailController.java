package com.example.demo.controller;

import com.example.demo.dto.AuditTrailRequest;
import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditTrailController {

    private final AuditTrailService auditService;

    public AuditTrailController(AuditTrailService auditService) {
        this.auditService = auditService;
    }

    // POST endpoint using DTO
    @PostMapping
    public ResponseEntity<AuditTrailRecord> log(@RequestBody AuditTrailRequest request) {
        AuditTrailRecord record = new AuditTrailRecord();
        record.setEventType(request.getEventType());
        record.setDetails(request.getDetails());
        record.setCredentialId(request.getCredentialId());

        return ResponseEntity.ok(auditService.logEvent(record));
    }

    // GET endpoint
    @GetMapping("/credential/{credentialId}")
    public ResponseEntity<List<AuditTrailRecord>> getByCredential(@PathVariable Long credentialId) {
        return ResponseEntity.ok(auditService.getLogsByCredential(credentialId));
    }
}
