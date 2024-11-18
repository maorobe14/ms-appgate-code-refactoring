package com.appgate.coderefactoring.domain.models;

import com.appgate.coderefactoring.domain.ports.in.SocialNetworkPort;
import com.appgate.coderefactoring.domain.ports.out.TweeterSocialMentionEvaluatorPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TweeterMention implements SocialNetworkPort {

    private String message;
    private String tweeterAccount;
    private String creationDate;
    private String tweeterUrl;

    @Autowired
    private TweeterSocialMentionEvaluatorPort tweeterSocialMentionEvaluatorPort;

    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetworkTweeterMention) {
        return tweeterSocialMentionEvaluatorPort.EvaluateSocialMentionsTweeter((TweeterMention)socialNetworkTweeterMention);
    }
}
