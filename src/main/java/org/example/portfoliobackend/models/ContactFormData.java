package org.example.portfoliobackend.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactFormData {
    @NotEmpty(message = "First Name is required")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;

    @NotEmpty(message = "Subject is required")
    private String subject;

    @NotEmpty(message = "Message is required")
    private String message;
}