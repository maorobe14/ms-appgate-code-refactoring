package com.appgate.coderefactoring.record.domain.ports.in;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;

public interface InsertAnalyzedTweetsUseCase {
    void insertAnalyzedTweetsUseCase(AnalyzedTweets analyzedTweets);
}
