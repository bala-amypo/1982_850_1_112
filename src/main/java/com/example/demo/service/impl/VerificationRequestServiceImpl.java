package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.AuditTrailService;
import com.example.demo.service.CredentialRecordService;
import com.example.demo.service.VerificationRequestService;
import com.example.demo.service.VerificationRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    private final VerificationRequestRepository repository;
    private final CredentialRecordService credentialService;
    private final VerificationRuleService ruleService;
    private final AuditTrailService auditService;

    public VerificationRequestServiceImpl(VerificationRequestRepository repository,
                                        CredentialRecordService credentialService,
                                        VerificationRuleService ruleService,
                                        AuditTrailService auditService) {
        this.repository = repository;
        this.credentialService = credentialService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }

    public VerificationRequest initiateVerification(VerificationRequest request) {
        return repository.save(request);
    }

    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest request = repository.findById(requestId).orElse(null);
        if (request != null) {
            CredentialRecord credential = credentialService.getAllCredentials().stream()
                .filter(c -> c.getId().equals(request.getCredentialId()))
                .findFirst().orElse(null);
            
            if (credential != null) {
                boolean isExpired = credential.getExpiryDate() != null && 
                    credential.getExpiryDate().isBefore(LocalDate.now());
                
                List<VerificationRule> activeRules = ruleService.getActiveRules();
                
                if (isExpired || activeRules.isEmpty()) {
                    request.setStatus("FAILED");
                } else {
                    request.setStatus("SUCCESS");
                }
                
                AuditTrailRecord audit = new AuditTrailRecord();
                audit.setCredentialId(request.getCredentialId());
                audit.setLoggedAt(LocalDateTime.now());
                auditService.logEvent(audit);
                
                return repository.save(request);
            }
        }
        return null;
    }

    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }
}