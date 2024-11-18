package com.appgate.coderefactoring.application.adapters;

import com.appgate.coderefactoring.application.services.socialnetwork.FacebookAnalyzer;
import com.appgate.coderefactoring.domain.models.FacebookMention;
import com.appgate.coderefactoring.domain.ports.out.FacebookSocialMentionEvaluatorPort;

public class FacebookSocialMentionEvaluatorAdapter implements FacebookSocialMentionEvaluatorPort {

    private static final int HIGH_RISK_CATEGORY = 1;
    private static final int MEDIUM_RISK_CATEGORY = 2;
    private static final int LOW_RISK_CATEGORY = 3;

    private static final double HIGH_RISK_THRESHOLD = 50.0;
    private static final double MEDIUM_RISK_THRESHOLD = 75.0;

    private static final String HIGH_RISK = "HIGH_RISK";
    private static final String MEDIUM_RISK = "MEDIUM_RISK";
    private static final String LOW_RISK = "LOW_RISK";

    @Override
    public String EvaluateSocialMentionsFacebook(FacebookMention facebookMention) {

        facebookMention.setMessage("facebookMessage: " + facebookMention.getMessage());
        String comments = appendFacebookComments(facebookMention);
        facebookMention.setMessage(facebookMention.getMessage() + " || comments: " +
                comments);

        double facebookScore = FacebookAnalyzer.calculateFacebookCommentsScore(facebookMention
                .getMessage().substring(facebookMention.getMessage().indexOf("comments:")));

        //dbService.insertFBPost(ANALYZED_FB_TABLE, facebookScore, message, socialMention.getFacebookAccount());
        return getRiskLevel(facebookScore);

    }

    private String appendFacebookComments(FacebookMention facebookMention) {
        String comments = facebookMention
                .getFacebookComments()
                .stream().reduce("", (h, c) -> h + " " + c);

        return comments;
    }

    public String getRiskLevel(double facebookScore) {
        int rangeCategory = (facebookScore < HIGH_RISK_THRESHOLD) ? HIGH_RISK_CATEGORY :
                (facebookScore >= HIGH_RISK_THRESHOLD && facebookScore < MEDIUM_RISK_THRESHOLD) ? MEDIUM_RISK_CATEGORY :
                        LOW_RISK_CATEGORY;

        return switch (rangeCategory) {
            case HIGH_RISK_CATEGORY -> HIGH_RISK;
            case MEDIUM_RISK_CATEGORY -> MEDIUM_RISK;
            default -> LOW_RISK;
        };
    }
}
