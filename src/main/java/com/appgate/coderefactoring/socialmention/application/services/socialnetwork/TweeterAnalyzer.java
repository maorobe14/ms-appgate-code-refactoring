package com.appgate.coderefactoring.socialmention.application.services.socialnetwork;

import java.util.Random;

public class TweeterAnalyzer {

    public static final int TWEETER_SCORE_RANGE = 21;  // Rango de generación de puntaje para Tweeter
    public static final double TWEETER_SCORE_DIVISOR = 10.0;
    public static final int TWEETER_SCORE_SHIFT = 10;

    public static double analyzeTweet(String message, String tweeterUrl, String tweeterAccount) {
        return (new Random().nextInt(TWEETER_SCORE_RANGE) - TWEETER_SCORE_SHIFT)/TWEETER_SCORE_DIVISOR;
    }
}
