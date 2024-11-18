package com.appgate.coderefactoring.socialmention.domain.events;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SocialMentionEventsDomain {

    private final ApplicationEventPublisher eventPublisher;


    public SocialMentionEventsDomain(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void eventAnalyzedFbPosts(String message, String facebookAccount, double score) {

        AnalyzedFbPosts eventAnalyzedFbPosts = new AnalyzedFbPosts();
        eventAnalyzedFbPosts.setMessage(message);
        eventAnalyzedFbPosts.setFacebookScore(score);
        eventAnalyzedFbPosts.setFacebookAccount(facebookAccount);

        eventPublisher.publishEvent(eventAnalyzedFbPosts);
    }

    public void eventAnalyzedTweets(String message, String tweeterUrl, double tweeterScore, String tweeterAccount) {

        AnalyzedTweets eventAnalyzedTweets = new AnalyzedTweets();
        eventAnalyzedTweets.setMessage(message);
        eventAnalyzedTweets.setTweeterScore(tweeterScore);
        eventAnalyzedTweets.setTweeterAccount(tweeterAccount);
        eventAnalyzedTweets.setTweeterUrl(tweeterUrl);

        eventPublisher.publishEvent(eventAnalyzedTweets);
    }


}
