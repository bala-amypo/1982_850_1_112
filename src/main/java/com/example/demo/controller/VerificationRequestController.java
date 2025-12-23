package com.example.demo.controller;

import com.example.demo.dto.VerificationRequestDto;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verifications")
public class VerificationRequestController {

    private final VerificationRequestService verificationService;

    public VerificationRequestController(VerificationRequestService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping
    public ResponseEntity<VerificationRequest> initiate(@Valid @RequestBody VerificationRequestDto requestDto) {
        VerificationRequest request = new VerificationRequest();
        request.setCredentialId(requestDto.getCredentialId());
        request.setRequestedBy(requestDto.getRequestedBy());
        request.setComments(requestDto.getComments());

        VerificationRequest created = verificationService.initiateVerification(request);
        return ResponseEntity.ok(created);
    }
}
