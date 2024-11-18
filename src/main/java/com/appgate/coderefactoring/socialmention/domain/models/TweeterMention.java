package com.appgate.coderefactoring.socialmention.domain.models;

import com.appgate.coderefactoring.socialmention.domain.ports.in.SocialNetworkPort;
import com.appgate.coderefactoring.socialmention.domain.ports.out.TweeterSocialMentionEvaluatorPort;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class TweeterMention implements SocialNetworkPort {

    private String message;
    private String tweeterAccount;
    private LocalDate creationDate;
    private String tweeterUrl;
    private TweeterSocialMentionEvaluatorPort tweeterSocialMentionEvaluatorPort;

    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetworkPort) {
        return tweeterSocialMentionEvaluatorPort.EvaluateSocialMentionsTweeter((TweeterMention) socialNetworkPort);
    }
}
