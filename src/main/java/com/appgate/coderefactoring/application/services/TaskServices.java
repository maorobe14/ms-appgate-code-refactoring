package com.appgate.coderefactoring.application.services;

import com.appgate.coderefactoring.domain.ports.in.GetSocialMentionsEvaluationUseCase;
import com.appgate.coderefactoring.domain.ports.in.SocialNetworkPort;
import org.springframework.stereotype.Service;

@Service
public class TaskServices implements GetSocialMentionsEvaluationUseCase {

    private final GetSocialMentionsEvaluationUseCase getSocialMentionsEvaluationUseCase;

    public TaskServices(GetSocialMentionsEvaluationUseCase getSocialMentionsEvaluationUseCase) {
        this.getSocialMentionsEvaluationUseCase = getSocialMentionsEvaluationUseCase;
    }

    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetwork) {
        return getSocialMentionsEvaluationUseCase.EvaluateSocialMentions(socialNetwork);
    }
}
