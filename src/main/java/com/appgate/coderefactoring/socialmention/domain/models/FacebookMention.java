package com.appgate.coderefactoring.socialmention.domain.models;

import com.appgate.coderefactoring.socialmention.domain.ports.out.FacebookSocialMentionEvaluatorPort;
import com.appgate.coderefactoring.socialmention.domain.ports.in.SocialNetworkPort;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacebookMention implements SocialNetworkPort {

    private String message;
    private String facebookAccount;
    private LocalDate creationDate;
    private List<String> facebookComments;
    private FacebookSocialMentionEvaluatorPort facebookSocialMentionEvaluatorPort;


    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetworkFacebookMention) {
        return facebookSocialMentionEvaluatorPort.EvaluateSocialMentionsFacebook((FacebookMention)socialNetworkFacebookMention);
    }
}
