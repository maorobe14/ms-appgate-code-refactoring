package com.appgate.coderefactoring.socialmention.infrastructure.mappers;

import com.appgate.coderefactoring.socialmention.domain.models.TweeterMention;
import com.appgate.coderefactoring.socialmention.domain.ports.out.TweeterSocialMentionEvaluatorPort;
import com.appgate.coderefactoring.socialmention.infrastructure.models.SocialMention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TweeterMentionMapper {

    @Autowired
    TweeterSocialMentionEvaluatorPort tweeterSocialMentionEvaluatorPort;

    public TweeterMention toTweeterMention(SocialMention socialMention) {
        if (socialMention == null) return null;

        return TweeterMention.builder().message(socialMention.getMessage())
                .tweeterAccount(socialMention.getTweeterAccount())
                .tweeterUrl(socialMention.getTweeterUrl())
                .creationDate(socialMention.getCreationDate())
                .tweeterSocialMentionEvaluatorPort(tweeterSocialMentionEvaluatorPort)
                .build();
    }

}
