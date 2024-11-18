package com.appgate.coderefactoring.domain.models;

import com.appgate.coderefactoring.domain.ports.in.SocialNetwork;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacebookMention implements SocialNetwork {
    private String message;
    private String facebookAccount;
    private String creationDate;
    private List<String> facebookComments;

    @Override
    public String EvaluateSocialMentions(Object object) {
        return "";
    }
}
