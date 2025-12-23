package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {

    // expired credentials
    List<CredentialRecord> findByExpiryDateBefore(LocalDate date);

    // credentials by holder
    List<CredentialRecord> findByHolder_Id(Long holderId);

    // credential by code
    Optional<CredentialRecord> findByCredentialCode(String credentialCode);
}
