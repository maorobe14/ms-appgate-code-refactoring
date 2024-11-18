package com.appgate.coderefactoring.socialmention.application.services.socialnetwork;

import java.util.Random;

public class FacebookAnalyzer {

    public static final int MIN_FACEBOOK_SCORE = -100;
    public static final int FACEBOOK_SCORE_RANGE = 201;

    public static double calculateFacebookCommentsScore(String comments) {
        return new Random().nextInt(101);
    }

    public static double analyzePost(double facebookScore) {
        if (facebookScore > MIN_FACEBOOK_SCORE)  return new Random().nextInt(FACEBOOK_SCORE_RANGE) + MIN_FACEBOOK_SCORE;
        return facebookScore;
    }

}
