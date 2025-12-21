package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    @Autowired
    private VerificationRequestRepository repository;

    public VerificationRequest initiateVerification(VerificationRequest request) {
        return repository.save(request);
    }

    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest request = repository.findById(requestId).orElse(null);
        if (request != null) {
            request.setStatus("PROCESSED");
            return repository.save(request);
        }
        return null;
    }

    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }
}