package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import org.springframework.stereotype.Service;

@Service
public class CredentialRecordServiceImpl {
    public CredentialRecord create(CredentialRecord record) {
        return record;
    }
    public CredentialRecord update(long id, CredentialRecord record) {
        return record;
    }
}
