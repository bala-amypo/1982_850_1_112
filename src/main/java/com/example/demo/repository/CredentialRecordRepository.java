package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {

    // Find a credential record by its unique code
    Optional<CredentialRecord> findByCredentialCode(String code);

    // Find all credentials by holder's user ID
    List<CredentialRecord> findByHolderId(Long holderId);
}
