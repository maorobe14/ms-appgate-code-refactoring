package com.appgate.coderefactoring.socialmention.application.adapters;

import com.appgate.coderefactoring.socialmention.application.services.socialnetwork.TweeterAnalyzer;
import com.appgate.coderefactoring.socialmention.domain.events.SocialMentionEventsDomain;
import com.appgate.coderefactoring.socialmention.domain.models.TweeterMention;
import com.appgate.coderefactoring.socialmention.domain.ports.out.TweeterSocialMentionEvaluatorPort;
import org.springframework.stereotype.Service;

import static com.appgate.coderefactoring.socialmention.commons.constants.SocialNetworkConstants.RiskLevels.*;
import static com.appgate.coderefactoring.socialmention.commons.constants.SocialNetworkConstants.riskCategories.*;

@Service
public class TweeterSocialMentionEvaluatorAdapter implements TweeterSocialMentionEvaluatorPort {

    private final SocialMentionEventsDomain socialMentionEventsDomain;
    private static final double LOW_RISK_THRESHOLD = -1;
    private static final double MEDIUM_RISK_THRESHOLD_LOWER = -0.5;
    private static final double MEDIUM_RISK_THRESHOLD_UPPER = 0.7;

    public TweeterSocialMentionEvaluatorAdapter(SocialMentionEventsDomain socialMentionEventsDomain) {
        this.socialMentionEventsDomain = socialMentionEventsDomain;
    }


    @Override
    public String EvaluateSocialMentionsTweeter(TweeterMention tweeterMention) {

        tweeterMention.setMessage("tweeterMessage: " + tweeterMention.getMessage());

        double tweeterScore = TweeterAnalyzer.analyzeTweet(
                tweeterMention.getMessage(),
                tweeterMention.getTweeterUrl(),
                tweeterMention.getTweeterAccount()
        );

        socialMentionEventsDomain.eventAnalyzedTweets(tweeterMention.getMessage(),tweeterMention.getTweeterUrl(),tweeterScore,tweeterMention.getTweeterAccount());
        //dbService.insertTweet(ANALYZED_TWEETS_TABLE, tweeterScore, message, socialMention.getTweeterAccount());
        return getRiskLevel(tweeterScore);
    }


    private String getRiskLevel(double tweeterScore) {


        int rangeCategory = (tweeterScore >= LOW_RISK_THRESHOLD && tweeterScore <= MEDIUM_RISK_THRESHOLD_LOWER) ?
                HIGH_RISK_CATEGORY :
                (tweeterScore > MEDIUM_RISK_THRESHOLD_LOWER && tweeterScore < MEDIUM_RISK_THRESHOLD_UPPER) ?
                        MEDIUM_RISK_CATEGORY :
                        LOW_RISK_CATEGORY;


        return switch (rangeCategory) {
            case HIGH_RISK_CATEGORY -> HIGH_RISK;
            case MEDIUM_RISK_CATEGORY -> MEDIUM_RISK;
            default -> LOW_RISK;
        };
    }
}
