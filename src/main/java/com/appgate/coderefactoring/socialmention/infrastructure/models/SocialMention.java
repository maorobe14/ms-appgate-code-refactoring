package com.appgate.coderefactoring.socialmention.infrastructure.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialMention {
    private String message;
    private String facebookAccount;
    private String tweeterAccount;
    @NotNull(message = "la fecha de creacion no puede ser nula")
    private LocalDate creationDate;
    private String tweeterUrl;
    private List<String> facebookComments;
}
