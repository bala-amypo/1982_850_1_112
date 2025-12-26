package com.example.demo.service.impl;


import java.util.List;
import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditTrailServiceImpl {

    private final AuditTrailRecordRepository auditTrailRepository;

    public AuditTrailServiceImpl(AuditTrailRecordRepository auditTrailRepository) {
        this.auditTrailRepository = auditTrailRepository;
    }

    @Override
   public AuditTrailRecord saveAudit(Long userId) {
        AuditTrailRecord record = new AuditTrailRecord(userId);
        return auditTrailRepository.save(record);
    }

    @Override
    public List<AuditTrailRecord> getLogsByCredential(Long credentialId) {
        return auditRepo.findByCredentialId(credentialId);
    }
}
