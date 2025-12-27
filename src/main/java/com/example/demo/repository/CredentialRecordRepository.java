package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {

    // Find a credential by its unique code
    Optional<CredentialRecord> findByCode(String code);

    // Fetch credentials by holderId (assuming entity has holderId field)
    List<CredentialRecord> findByHolderId(Long holderId);

    // Find all credentials that have expired before a specific date (assuming entity has expiryDate field)
    @Query("SELECT c FROM CredentialRecord c WHERE c.expiryDate < :date")
    List<CredentialRecord> findExpiredBefore(LocalDate date);

    // Find credentials by status (assuming entity has status field)
    @Query("SELECT c FROM CredentialRecord c WHERE c.status = :status")
    List<CredentialRecord> findByStatus(String status);

    // Find credentials by issuer and type (assuming entity has issuer and credentialType fields)
    @Query("SELECT c FROM CredentialRecord c WHERE c.issuer = :issuer AND c.credentialType = :type")
    List<CredentialRecord> findByIssuerAndType(String issuer, String type);
}
