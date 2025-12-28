package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    private final CredentialRecordRepository repository;

    public CredentialRecordServiceImpl(CredentialRecordRepository repository) {
        this.repository = repository;
    }

    public CredentialRecord createCredential(CredentialRecord record) {
        if (record.getExpiryDate() != null && record.getExpiryDate().isBefore(LocalDate.now())) {
            record.setStatus("EXPIRED");
        } else if (record.getStatus() == null) {
            record.setStatus("VALID");
        }
        return repository.save(record);
    }

    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return repository.findByHolderId(holderId);
    }

    public CredentialRecord getCredentialByCode(String code) {
        return repository.findByCredentialCode(code).orElse(null);
    }

    public List<CredentialRecord> getAllCredentials() {
        return repository.findAll();
    }

    public CredentialRecord updateCredential(Long id, CredentialRecord record) {
        CredentialRecord existing = repository.findById(id).orElse(null);
        if (existing != null) {
            if (record.getTitle() != null) existing.setTitle(record.getTitle());
            if (record.getIssuer() != null) existing.setIssuer(record.getIssuer());
            if (record.getCredentialType() != null) existing.setCredentialType(record.getCredentialType());
            if (record.getExpiryDate() != null) existing.setExpiryDate(record.getExpiryDate());
            if (record.getMetadataJson() != null) existing.setMetadataJson(record.getMetadataJson());
            if (record.getCredentialCode() != null) existing.setCredentialCode(record.getCredentialCode());
            return repository.save(existing);
        }
        return null;
    }
}