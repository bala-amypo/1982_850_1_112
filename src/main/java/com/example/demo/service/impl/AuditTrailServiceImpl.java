package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import com.example.demo.service.AuditTrailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditTrailServiceImpl implements AuditTrailService {

    private final AuditTrailRecordRepository repo;

    public AuditTrailServiceImpl(AuditTrailRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public AuditTrailRecord saveAudit(Long credentialId) {
        return repo.save(new AuditTrailRecord(credentialId));
    }

    @Override
    public List<AuditTrailRecord> findAll() {
        return repo.findAll();
    }
}
