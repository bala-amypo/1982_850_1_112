package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    private final VerificationRequestRepository repository;

    public VerificationRequestServiceImpl(VerificationRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        request.setStatus("PENDING"); // set default status
        return repository.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest request = repository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Verification request not found with id: " + requestId));
        request.setStatus("PROCESSED");
        return repository.save(request);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }
}
