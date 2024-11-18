package com.appgate.coderefactoring.socialmention.infrastructure.factory;

import com.appgate.coderefactoring.socialmention.domain.ports.in.SocialNetworkPort;
import com.appgate.coderefactoring.socialmention.infrastructure.mappers.FacebookMentionMapper;
import com.appgate.coderefactoring.socialmention.infrastructure.mappers.TweeterMentionMapper;
import com.appgate.coderefactoring.socialmention.infrastructure.models.SocialMention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocialNetworkFactory {
    @Autowired
    TweeterMentionMapper tweeterMentionMapper;

    @Autowired
    FacebookMentionMapper facebookMentionMapper;
    public  SocialNetworkPort createSocialNetworkPort(SocialMention socialMention) {

        if (socialMention.getFacebookAccount() != null) {
            return facebookMentionMapper.toFacebookMention(socialMention);
        } else {
            return tweeterMentionMapper.toTweeterMention(socialMention);
        }

    }
}
