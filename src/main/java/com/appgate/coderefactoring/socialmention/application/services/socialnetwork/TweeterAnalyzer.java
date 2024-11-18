package com.appgate.coderefactoring.socialmention.application.services.socialnetwork;

import java.util.Random;

public class TweeterAnalyzer {

    public static double analyzeTweet(String message, String tweeterUrl, String tweeterAccount) {
        return (new Random().nextInt(21) - 10)/10.0;
    }
}
