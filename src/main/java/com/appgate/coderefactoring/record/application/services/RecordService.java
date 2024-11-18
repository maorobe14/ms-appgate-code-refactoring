package com.appgate.coderefactoring.record.application.services;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import com.appgate.coderefactoring.record.domain.ports.in.InsertAnalyzedFbPostsUseCase;
import com.appgate.coderefactoring.record.domain.ports.in.InsertAnalyzedTweetsUseCase;
import org.springframework.stereotype.Service;

@Service
public class RecordService implements InsertAnalyzedFbPostsUseCase, InsertAnalyzedTweetsUseCase {

    private final InsertAnalyzedFbPostsUseCase insertAnalyzedFbPostsUseCase;
    private final InsertAnalyzedTweetsUseCase insertAnalyzedTweetsUseCase;

    public RecordService(InsertAnalyzedFbPostsUseCase insertAnalyzedFbPostsUseCase, InsertAnalyzedTweetsUseCase insertAnalyzedTweetsUseCase) {
        this.insertAnalyzedFbPostsUseCase = insertAnalyzedFbPostsUseCase;
        this.insertAnalyzedTweetsUseCase = insertAnalyzedTweetsUseCase;
    }

    @Override
    public void insertAnalyzedFbPosts(AnalyzedFbPosts analyzedFbPosts) {
        insertAnalyzedFbPostsUseCase.insertAnalyzedFbPosts(analyzedFbPosts);
    }

    @Override
    public void insertAnalyzedTweets(AnalyzedTweets analyzedTweets) {
        insertAnalyzedTweetsUseCase.insertAnalyzedTweets(analyzedTweets);
    }
}
