package com.appgate.coderefactoring.record.infrastructure.events;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import com.appgate.coderefactoring.record.infrastructure.services.AnalyzedFbPostsProcesorServices;
import com.appgate.coderefactoring.record.infrastructure.services.AnalyzedTweetsProcesorServices;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SocialMentionEventListener {

    private final AnalyzedFbPostsProcesorServices mentionProcesorService;
    private final AnalyzedTweetsProcesorServices analyzedTweetsProcesorServices;

    public SocialMentionEventListener(AnalyzedFbPostsProcesorServices mentionProcesorService, AnalyzedTweetsProcesorServices analyzedTweetsProcesorServices) {
        this.mentionProcesorService = mentionProcesorService;
        this.analyzedTweetsProcesorServices = analyzedTweetsProcesorServices;
    }

    @EventListener
    public void eventListenerAnalyzedFbPostEvent(AnalyzedFbPosts eventAnalyzedFbPosts) {
        mentionProcesorService.processAnalyzedFbPostEvent(eventAnalyzedFbPosts);
    }

    @EventListener
    public void eventListenerAnalyzedTweetsEvent(AnalyzedTweets eventAnalyzedTweets) {
        analyzedTweetsProcesorServices.processAnalyzedTweetsEvent(eventAnalyzedTweets);
    }
}
