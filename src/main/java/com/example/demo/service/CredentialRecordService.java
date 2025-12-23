package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

    List<CredentialRecord> getByHolderId(Long holderId);

    CredentialRecord getByCredentialCode(String code);
}
