package com.appgate.coderefactoring.socialmention.infrastructure.mappers;

import com.appgate.coderefactoring.socialmention.domain.models.FacebookMention;
import com.appgate.coderefactoring.socialmention.domain.ports.out.FacebookSocialMentionEvaluatorPort;
import com.appgate.coderefactoring.socialmention.infrastructure.models.SocialMention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookMentionMapper {

    @Autowired
    FacebookSocialMentionEvaluatorPort facebookSocialMentionEvaluatorPort;

    public FacebookMention toFacebookMention(SocialMention socialMention) {
        if (socialMention == null) return null;

        return FacebookMention.builder().message(socialMention.getMessage())
                .facebookAccount(socialMention.getFacebookAccount())
                .creationDate(socialMention.getCreationDate())
                .facebookComments(socialMention.getFacebookComments())
                .facebookSocialMentionEvaluatorPort(facebookSocialMentionEvaluatorPort)
                .build();
    }

}
