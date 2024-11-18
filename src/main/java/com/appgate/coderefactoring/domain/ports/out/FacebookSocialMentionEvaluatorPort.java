package com.appgate.coderefactoring.domain.ports.out;

import com.appgate.coderefactoring.domain.models.FacebookMention;

public interface FacebookSocialMentionEvaluatorPort {
    String EvaluateSocialMentionsFacebook(FacebookMention facebookMention);
}
