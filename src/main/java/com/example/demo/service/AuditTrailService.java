package com.example.demo.service;

import com.example.demo.entity.AuditTrailRecord;
import java.util.List;

public interface AuditTrailService {

    // Save a new audit record
    AuditTrailRecord logEvent(AuditTrailRecord record);

    // Retrieve audit records for a specific credential
    List<AuditTrailRecord> getLogsByCredential(Long credentialId);
}
