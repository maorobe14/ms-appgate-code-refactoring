package com.appgate.coderefactoring.socialmention.application.services.socialnetwork;

import java.util.Random;

public class FacebookAnalyzer {

    public static double calculateFacebookCommentsScore(String comments) {
        return new Random().nextInt(101);
    }

    public static double analyzePost(double facebookScore) {
        if (facebookScore > -100) return new Random().nextInt(201) - 100;
        return facebookScore;
    }

}
