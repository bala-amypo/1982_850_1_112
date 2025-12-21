package com.example.demo.service.impl;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService {

    @Autowired
    private CredentialHolderProfileRepository repository;

    public CredentialHolderProfile createHolder(CredentialHolderProfile profile) {
        return repository.save(profile);
    }

    public CredentialHolderProfile getHolderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holder not found"));
    }

    public CredentialHolderProfile updateStatus(Long id, boolean active) {
        CredentialHolderProfile holder = getHolderById(id);
        holder.setActive(active);
        return repository.save(holder);
    }
}