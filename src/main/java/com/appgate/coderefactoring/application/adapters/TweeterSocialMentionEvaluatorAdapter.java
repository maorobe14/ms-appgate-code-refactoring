package com.appgate.coderefactoring.application.adapters;

import com.appgate.coderefactoring.application.services.socialnetwork.TweeterAnalyzer;
import com.appgate.coderefactoring.domain.models.TweeterMention;
import com.appgate.coderefactoring.domain.ports.out.TweeterSocialMentionEvaluatorPort;

public class TweeterSocialMentionEvaluatorAdapter implements TweeterSocialMentionEvaluatorPort {

    private static final int HIGH_RISK_CATEGORY = 1;
    private static final int MEDIUM_RISK_CATEGORY = 2;
    private static final int LOW_RISK_CATEGORY = 3;

    // Definición de constantes para los rangos de puntaje
    private static final double LOW_RISK_THRESHOLD = -1;
    private static final double MEDIUM_RISK_THRESHOLD_LOWER = -0.5;
    private static final double MEDIUM_RISK_THRESHOLD_UPPER = 0.7;

    private static final String HIGH_RISK = "HIGH_RISK";
    private static final String MEDIUM_RISK = "MEDIUM_RISK";
    private static final String LOW_RISK = "LOW_RISK";

    @Override
    public String EvaluateSocialMentionsTweeter(TweeterMention tweeterMention) {

        tweeterMention.setMessage("tweeterMessage: " + tweeterMention.getMessage());

        double tweeterScore = TweeterAnalyzer.analyzeTweet(
                tweeterMention.getMessage(),
                tweeterMention.getTweeterUrl(),
                tweeterMention.getTweeterAccount()
        );

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
