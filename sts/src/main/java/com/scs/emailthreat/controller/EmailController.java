package com.scs.emailthreat.controller;

import com.scs.emailthreat.dto.EmailRequestDTO;
import com.scs.emailthreat.dto.EmailResponseDTO;
import com.scs.emailthreat.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<EmailResponseDTO> analyze(@RequestBody EmailRequestDTO request) {

        if (request.getEmailText() == null || request.getEmailText().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new EmailResponseDTO("INVALID_INPUT", 0.0));
        }

        return ResponseEntity.ok(emailService.analyze(request.getEmailText()));
    }
}