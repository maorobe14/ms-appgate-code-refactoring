package com.appgate.coderefactoring.domain.ports.out;

import com.appgate.coderefactoring.domain.models.FacebookMention;
import com.appgate.coderefactoring.domain.models.TweeterMention;

public interface TweeterSocialMentionEvaluatorPort {
    String EvaluateSocialMentionsTweeter(TweeterMention tweeterMention);
}
