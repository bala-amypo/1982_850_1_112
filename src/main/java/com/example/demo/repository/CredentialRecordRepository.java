package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {

    List<CredentialRecord> findByHolders_Id(Long holderId);

    Optional<CredentialRecord> findByCredentialCode(String credentialCode);
}
