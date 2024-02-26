package org.example.portfoliobackend.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.portfoliobackend.models.ContactFormData;
import org.example.portfoliobackend.services.EmailService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ContactFormSubmitController {
    private final EmailService emailService;

    @PostMapping("/sendMail")
    public String sendMail(@Valid @RequestBody ContactFormData details) {
        log.info("Received Email Details {}", details);
        return emailService.sendSimpleMail(details);
    }
}