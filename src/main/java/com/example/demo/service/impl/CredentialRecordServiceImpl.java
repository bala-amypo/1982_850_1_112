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
        return repository.save(credential);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord credential) {
        CredentialRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credential not found"));

        existing.setCredentialCode(credential.getCredentialCode());
        existing.setCredentialTitle(credential.getCredentialTitle()); // updated
        existing.setCredentialType(credential.getCredentialType());
        existing.setIssuer(credential.getIssuer());
        existing.setExpiryDate(credential.getExpiryDate());
        existing.setStatus(credential.getStatus());
        existing.setHolderId(credential.getHolderId());
        existing.setMetadata(credential.getMetadata());
        existing.setRules(credential.getRules());

        return repository.save(existing);
    }

    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return repository.findByHolderId(holderId);
    }

    @Override
    public CredentialRecord findCredentialByCode(String code) {
        return repository.findByCredentialCode(code)
                .orElseThrow(() -> new RuntimeException("Credential not found"));
    }
}
