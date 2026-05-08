package com.scs.emailthreat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scs.emailthreat.model.EmailEntity;
import com.scs.emailthreat.repository.EmailRepository;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    EmailRepository repository;

    @GetMapping("/emails")
    public List<EmailEntity> getAllEmails() {
        return repository.findAll();
    }
}
