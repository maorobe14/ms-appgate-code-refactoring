package com.appgate.coderefactoring.socialmention.application.services;

import com.appgate.coderefactoring.socialmention.domain.ports.in.GetSocialMentionsEvaluationUseCase;
import com.appgate.coderefactoring.socialmention.domain.ports.in.SocialNetworkPort;
import org.springframework.stereotype.Service;

@Service
public class SocialMentionService implements GetSocialMentionsEvaluationUseCase {

    private final GetSocialMentionsEvaluationUseCase getSocialMentionsEvaluationUseCase;

    public SocialMentionService(GetSocialMentionsEvaluationUseCase getSocialMentionsEvaluationUseCase) {
        this.getSocialMentionsEvaluationUseCase = getSocialMentionsEvaluationUseCase;
    }

    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetwork) {
        return getSocialMentionsEvaluationUseCase.EvaluateSocialMentions(socialNetwork);
    }
}
