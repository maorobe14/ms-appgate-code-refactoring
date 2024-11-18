package com.appgate.coderefactoring.record.domain.ports.in;

import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;

public interface InsertAnalyzedTweetsUseCase {
    void insertAnalyzedTweets(AnalyzedTweets analyzedTweets);
}
