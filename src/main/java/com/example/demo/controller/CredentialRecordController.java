package com.example.demo.controller;

import com.example.demo.dto.CredentialRecordRequest;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CredentialRecord> createCredential(@Valid @RequestBody CredentialRecordRequest request) {
        CredentialRecord credential = new CredentialRecord();
        credential.setCredentialCode(request.getCredentialCode());
        credential.setHolderId(request.getHolderId());
        credential.setTitle(request.getTitle());
        credential.setDescription(request.getDescription());

        CredentialRecord created = credentialService.createCredential(credential);
        return ResponseEntity.ok(created);
    }

    // Update an existing credential
    @PutMapping("/{id}")
    public ResponseEntity<CredentialRecord> updateCredential(
            @PathVariable Long id,
            @Valid @RequestBody CredentialRecordRequest request
    ) {
        CredentialRecord credential = new CredentialRecord();
        credential.setCredentialCode(request.getCredentialCode());
        credential.setHolderId(request.getHolderId());
        credential.setTitle(request.getTitle());
        credential.setDescription(request.getDescription());

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
