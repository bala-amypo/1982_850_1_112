package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;

import java.util.List;
import java.util.Optional;

public interface CredentialRecordService {
    CredentialRecord createCredential(CredentialRecord credential);
    CredentialRecord updateCredential(Long id, CredentialRecord credential);
    List<CredentialRecord> getCredentialsByHolder(Long holderId);
    Optional<CredentialRecord> findCredentialByCode(String code); // <-- returns Optional
}
