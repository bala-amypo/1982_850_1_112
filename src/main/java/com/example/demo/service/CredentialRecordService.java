package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

    /**
     * Create a new credential record.
     *
     * @param credential the credential to create
     * @return the created credential
     */
    CredentialRecord createCredential(CredentialRecord credential);

    /**
     * Update an existing credential record by ID.
     *
     * @param id the ID of the credential to update
     * @param credential the updated credential data
     * @return the updated credential
     */
    CredentialRecord updateCredential(Long id, CredentialRecord credential);

    /**
     * Retrieve all credentials for a specific holder ID.
     *
     * @param holderId the ID of the credential holder
     * @return list of credentials for the holder
     */
    List<CredentialRecord> getCredentialsByHolder(Long holderId);

    /**
     * Retrieve a credential by its credential code.
     *
     * @param code the credential code
     * @return the matching credential
     */
    CredentialRecord getCredentialByCode(String code);
}
