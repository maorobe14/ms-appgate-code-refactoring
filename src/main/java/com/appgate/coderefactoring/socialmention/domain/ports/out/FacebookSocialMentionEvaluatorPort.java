package com.appgate.coderefactoring.socialmention.domain.ports.out;

import com.appgate.coderefactoring.socialmention.domain.models.FacebookMention;

public interface FacebookSocialMentionEvaluatorPort {
    String EvaluateSocialMentionsFacebook(FacebookMention facebookMention);
}
