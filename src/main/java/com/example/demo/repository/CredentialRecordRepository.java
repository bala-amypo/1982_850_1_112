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

    // Fetch credentials by holderId (matches entity field)
    List<CredentialRecord> findByHolderId(Long holderId);

    // Find a credential by its unique code
    Optional<CredentialRecord> findByCredentialCode(String credentialCode);

    // Find all credentials that have expired before a specific date
    @Query("SELECT c FROM CredentialRecord c WHERE c.expiryDate < :date")
    List<CredentialRecord> findExpiredBefore(LocalDate date);

    // Find credentials by status
    @Query("SELECT c FROM CredentialRecord c WHERE c.status = :status")
    List<CredentialRecord> findByStatusUsingHql(String status);

    // Find credentials by issuer and type
    @Query("SELECT c FROM CredentialRecord c WHERE c.issuer = :issuer AND c.credentialType = :type")
    List<CredentialRecord> searchByIssuerAndType(String issuer, String type);
}
