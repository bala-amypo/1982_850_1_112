package com.example.demo.repository;

import com.example.demo.entity.CredentialHolderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialHolderProfileRepository
        extends JpaRepository<CredentialHolderProfile, Long> {

    // Add ONLY custom query methods here if needed
}
