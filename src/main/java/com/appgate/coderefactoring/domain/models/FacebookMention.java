package com.appgate.coderefactoring.domain.models;

import com.appgate.coderefactoring.domain.ports.out.FacebookSocialMentionEvaluatorPort;
import com.appgate.coderefactoring.domain.ports.in.SocialNetworkPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacebookMention implements SocialNetworkPort {

    private String message;
    private String facebookAccount;
    private String creationDate;
    private List<String> facebookComments;

    @Autowired
    private FacebookSocialMentionEvaluatorPort facebookSocialMentionEvaluator;


    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetworkFacebookMention) {
        return facebookSocialMentionEvaluator.EvaluateSocialMentionsFacebook((FacebookMention)socialNetworkFacebookMention);
    }
}
