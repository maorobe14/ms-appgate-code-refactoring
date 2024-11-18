package com.appgate.coderefactoring.socialmention.infrastructure.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDate creationDate;
    private String tweeterUrl;
    private List<String> facebookComments;
}
