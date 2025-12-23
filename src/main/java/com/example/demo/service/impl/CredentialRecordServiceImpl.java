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
    public List<CredentialRecord> getByHolderId(Long holderId) {
        return repository.findByHolders_Id(holderId);
    }

    @Override
    public CredentialRecord getByCredentialCode(String code) {
        return repository.findByCredentialCode(code)
                .orElseThrow(() -> new RuntimeException("Credential not found"));
    }

    // New methods
    @Override
    public CredentialRecord createCredential(CredentialRecord credential) {
        return repository.save(credential);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord credential) {
        CredentialRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credential not found"));
        existing.setCredentialCode(credential.getCredentialCode());
        existing.setTitle(credential.getTitle());
        existing.setCredentialType(credential.getCredentialType());
        existing.setIssuer(credential.getIssuer());
        existing.setExpiryDate(credential.getExpiryDate());
        existing.setStatus(credential.getStatus());
        existing.setHolders(credential.getHolders());
        return repository.save(existing);
    }

    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return repository.findByHolders_Id(holderId);
    }

    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return repository.findByCredentialCode(code)
                .orElseThrow(() -> new RuntimeException("Credential not found"));
    }
}
