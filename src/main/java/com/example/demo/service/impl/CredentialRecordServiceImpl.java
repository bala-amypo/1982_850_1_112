package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository repository;

    public CredentialRecord createCredential(CredentialRecord record) {
        if (record.getExpiryDate() != null && record.getExpiryDate().isBefore(LocalDate.now())) {
            record.setStatus("EXPIRED");
        } else {
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
            existing.setTitle(record.getTitle());
            existing.setIssuer(record.getIssuer());
            existing.setCredentialType(record.getCredentialType());
            existing.setExpiryDate(record.getExpiryDate());
            existing.setMetadataJson(record.getMetadataJson());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteCredential(Long id) {
        repository.deleteById(id);
    }
}