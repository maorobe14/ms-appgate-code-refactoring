package com.appgate.coderefactoring.application.services.socialnetwork;

import java.util.Random;

public class FacebookAnalyzer {

    public static double calculateFacebookCommentsScore(String comments) {
        return new Random().nextInt(201) - 100;
    }

}
