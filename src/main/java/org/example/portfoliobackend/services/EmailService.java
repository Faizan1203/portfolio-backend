package org.example.portfoliobackend.services;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.example.portfoliobackend.models.ContactFormData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Slf4j
@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final String myEmail;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender javaMailSender, @Value("${spring.mail.username}") String myEmail, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.myEmail = myEmail;
        this.templateEngine = templateEngine;
    }

    private String processTemplate(ContactFormData contactFormData) {
        Context context = new Context();
        context.setVariable("firstName", contactFormData.getFirstName());
        context.setVariable("lastName", contactFormData.getLastName());
        context.setVariable("subject", contactFormData.getSubject());
        context.setVariable("message", contactFormData.getMessage());
        context.setVariable("email", contactFormData.getEmail());
        return templateEngine.process("emailToCreator", context);
    }

    public String sendSimpleMail(ContactFormData contactFormData) {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);

            helper.setFrom(myEmail);
            helper.setTo(myEmail);
            helper.setSubject("New message from your Portfolio");
            String mailContent = processTemplate(contactFormData);
            helper.setText(mailContent, true);

            javaMailSender.send(mailMessage);
            log.info("Mail Sent Successfully...");
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            log.error("Error while Sending Mail", e);
            return "Error while Sending Mail";
        }
    }
}