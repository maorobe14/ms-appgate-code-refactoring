package com.appgate.coderefactoring.socialmention.domain.ports.out;

import com.appgate.coderefactoring.socialmention.domain.models.TweeterMention;

public interface TweeterSocialMentionEvaluatorPort {
    String EvaluateSocialMentionsTweeter(TweeterMention tweeterMention);
}
