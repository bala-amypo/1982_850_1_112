package com.example.demo.service;


import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

    List<CredentialRecord> getByHolderId(Long holderId);

    CredentialRecord getByCredentialCode(String code);



    import jakarta.persistence.*;
    import java.time.LocalDate;
    import java.util.Set;

    @Entity
    @Table(name = "credential_record")
    public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String credentialCode;
    private String title;
    private String credentialType;
    private String issuer;
    private LocalDate expiryDate;
    private String status;

    @ManyToMany
    @JoinTable(
        name = "credential_holder_records",
        joinColumns = @JoinColumn(name = "credential_id"),
        inverseJoinColumns = @JoinColumn(name = "holder_id")
    )
    private Set<CredentialHolderProfile> holders;

    
    }
    package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

    List<CredentialRecord> getByHolderId(Long holderId);

    CredentialRecord getByCredentialCode(String code);
}
}
