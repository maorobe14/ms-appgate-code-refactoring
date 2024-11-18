package com.appgate.coderefactoring.domain.models;

import com.appgate.coderefactoring.domain.ports.in.SocialNetwork;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TweeterMention implements SocialNetwork {
    private String message;
    private String tweeterAccount;
    private String creationDate;
    private String tweeterUrl;

    @Override
    public String EvaluateSocialMentions(Object object) {
        return "";
    }
}
