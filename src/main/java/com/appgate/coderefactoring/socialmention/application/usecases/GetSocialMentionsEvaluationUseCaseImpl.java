package com.appgate.coderefactoring.socialmention.application.usecases;

import com.appgate.coderefactoring.socialmention.domain.ports.in.GetSocialMentionsEvaluationUseCase;
import com.appgate.coderefactoring.socialmention.domain.ports.in.SocialNetworkPort;
import org.springframework.stereotype.Service;

@Service
public class GetSocialMentionsEvaluationUseCaseImpl implements GetSocialMentionsEvaluationUseCase {



    @Override
    public String EvaluateSocialMentions(SocialNetworkPort socialNetwork) {
        return socialNetwork.EvaluateSocialMentions(socialNetwork);
    }
}
