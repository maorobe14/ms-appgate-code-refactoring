package com.appgate.coderefactoring.application.usecases;

import com.appgate.coderefactoring.domain.ports.in.GetSocialMentionsEvaluationUseCase;
import com.appgate.coderefactoring.domain.ports.in.SocialNetworkPort;
import org.springframework.stereotype.Service;

@Service
public class GetSocialMentionsEvaluationUseCaseImpl implements GetSocialMentionsEvaluationUseCase {



    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetwork) {
        return socialNetwork.EvaluateSocialMentions(socialNetwork);
    }
}
