package com.appgate.coderefactoring.socialmention.application.adapters;

import com.appgate.coderefactoring.socialmention.application.services.socialnetwork.FacebookAnalyzer;
import com.appgate.coderefactoring.socialmention.domain.events.SocialMentionEventsDomain;
import com.appgate.coderefactoring.socialmention.domain.models.FacebookMention;
import com.appgate.coderefactoring.socialmention.domain.ports.out.FacebookSocialMentionEvaluatorPort;
import org.springframework.stereotype.Service;

import static com.appgate.coderefactoring.socialmention.commons.constants.SocialNetworkConstants.RiskLevelsFaceBook.*;
import static com.appgate.coderefactoring.socialmention.commons.constants.SocialNetworkConstants.riskCategories.*;

@Service
public class FacebookSocialMentionEvaluatorAdapter implements FacebookSocialMentionEvaluatorPort {

    private final SocialMentionEventsDomain socialMentionEventsDomain;
    private static final double HIGH_RISK_THRESHOLD = 50.0;
    private static final double MEDIUM_RISK_THRESHOLD = 75.0;
    private static final double LOW_COMMENTS_SCORE_THRESHOLD  = 50.0;
    private static final double PENALTY_SCORE   = -100.0;

    public FacebookSocialMentionEvaluatorAdapter(SocialMentionEventsDomain socialMentionEventsDomain) {
        this.socialMentionEventsDomain = socialMentionEventsDomain;
    }

    @Override
    public String EvaluateSocialMentionsFacebook(FacebookMention facebookMention) {

        double facebookScore = 0;

        facebookMention.setMessage("facebookMessage: " + facebookMention.getMessage());
        String comments = appendFacebookComments(facebookMention);
        facebookMention.setMessage(facebookMention.getMessage() + " || comments: " +
                comments);

        double facebookCommentsScore = FacebookAnalyzer.calculateFacebookCommentsScore(facebookMention
                .getMessage().substring(facebookMention.getMessage().indexOf("comments:")));

        facebookScore = facebookScoreAnalyzer(facebookCommentsScore, facebookScore);

        facebookScore = FacebookAnalyzer.analyzePost(facebookScore);

        socialMentionEventsDomain.eventAnalyzedFbPosts(facebookMention.getMessage(),facebookMention.getFacebookAccount(),facebookScore);
        return getRiskLevel(facebookScore);

    }

    private double facebookScoreAnalyzer(double facebookCommentsScore, double facebookScore){
        if (facebookCommentsScore < LOW_COMMENTS_SCORE_THRESHOLD) return Double.sum(facebookScore, PENALTY_SCORE);
        return facebookScore;
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
            case HIGH_RISK_CATEGORY -> HIGH_RISK_FB;
            case MEDIUM_RISK_CATEGORY -> MEDIUM_RISK_FB;
            default -> LOW_RISK_FB;
        };
    }
}
