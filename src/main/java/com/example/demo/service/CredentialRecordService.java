package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

    // Existing methods
    List<CredentialRecord> getByHolderId(Long holderId);
    CredentialRecord getByCredentialCode(String code);

    // Add these methods for your controller
    CredentialRecord createCredential(CredentialRecord credential);
    CredentialRecord updateCredential(Long id, CredentialRecord credential);
    List<CredentialRecord> getCredentialsByHolder(Long holderId);
    CredentialRecord getCredentialByCode(String code);
}
