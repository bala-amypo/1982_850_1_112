package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing CredentialRecord entities.
 */
public interface CredentialRecordService {

    /**
     * Create and save a new credential record.
     *
     * @param credential the credential to create
     * @return the saved credential
     */
    CredentialRecord createCredential(CredentialRecord credential);

    /**
     * Update an existing credential record by its ID.
     *
     * @param id the ID of the credential to update
     * @param credential the updated credential data
     * @return the updated credential
     */
    CredentialRecord updateCredential(Long id, CredentialRecord credential);

    /**
     * Retrieve all credentials belonging to a specific holder.
     *
     * @param holderId the ID of the holder
     * @return list of credentials
     */
    List<CredentialRecord> getCredentialsByHolder(Long holderId);

    /**
     * Retrieve a credential by its unique code.
     *
     * @param credentialCode the unique code of the credential
     * @return the credential
     */
    CredentialRecord getCredentialByCode(String credentialCode);

    /**
     * Optionally, check if a credential exists by its code.
     *
     * @param credentialCode the unique code
     * @return Optional containing credential if found
     */
    Optional<CredentialRecord> findCredentialByCode(String credentialCode);
}
