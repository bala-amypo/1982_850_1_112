package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    private final CredentialRecordRepository repository;

    public CredentialRecordServiceImpl(CredentialRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public CredentialRecord createCredential(CredentialRecord credential) {
        // Save a new credential record
        return repository.save(credential);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord credential) {
        // Find existing credential by ID
        CredentialRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credential with ID " + id + " not found"));

        // Update fields
        existing.setCode(credential.getCode());
        existing.setTitle(credential.getTitle());
        existing.setType(credential.getType());
        existing.setIssuer(credential.getIssuer());
        existing.setExpiryDate(credential.getExpiryDate());
        existing.setStatus(credential.getStatus());
        existing.setHolderId(credential.getHolderId());
        existing.setMetadata(credential.getMetadata());
        existing.setRules(credential.getRules());

        // Save updated record
        return repository.save(existing);
    }

    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        // Fetch all credentials for a specific holder
        return repository.findByHolderId(holderId);
    }

    @Override
    public CredentialRecord getCredentialByCode(String code) {
        // Fetch credential by unique code
        return repository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Credential with code " + code + " not found"));
    }
}
