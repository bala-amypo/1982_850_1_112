package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialRecordController {

    @PostMapping
    public CredentialRecord create(@RequestBody CredentialRecord record) {
        return record;
    }

    @PutMapping("/{id}")
    public CredentialRecord update(@PathVariable long id, @RequestBody CredentialRecord record) {
        return record;
    }

    @GetMapping("/holder/{id}")
    public List<CredentialRecord> getByHolder(@PathVariable long id) {
        return List.of();
    }

    @GetMapping("/code/{code}")
    public CredentialRecord getByCode(@PathVariable String code) {
        return new CredentialRecord();
    }
}
