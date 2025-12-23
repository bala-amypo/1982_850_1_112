package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credentials")
public class CredentialRecordController {

    private final CredentialRecordService credentialService;

    public CredentialRecordController(CredentialRecordService credentialService) {
        this.credentialService = credentialService;
    }

    // Create a new credential
    @PostMapping
    public ResponseEntity<CredentialRecord> createCredential(@RequestBody CredentialRecord credential) {
        CredentialRecord created = credentialService.createCredential(credential);
        return ResponseEntity.ok(created);
    }

    // Update an existing credential
    @PutMapping("/{id}")
    public ResponseEntity<CredentialRecord> updateCredential(
            @PathVariable Long id,
            @RequestBody CredentialRecord credential
    ) {
        CredentialRecord updated = credentialService.updateCredential(id, credential);
        return ResponseEntity.ok(updated);
    }

    // Get all credentials for a specific holder
    @GetMapping("/holder/{holderId}")
    public ResponseEntity<List<CredentialRecord>> getCredentialsByHolder(@PathVariable Long holderId) {
        List<CredentialRecord> credentials = credentialService.getCredentialsByHolder(holderId);
        return ResponseEntity.ok(credentials);
    }

    // Get a credential by its code
    @GetMapping("/code/{credentialCode}")
    public ResponseEntity<CredentialRecord> getCredentialByCode(@PathVariable String credentialCode) {
        CredentialRecord credential = credentialService.getCredentialByCode(credentialCode);
        return ResponseEntity.ok(credential);
    }
}
