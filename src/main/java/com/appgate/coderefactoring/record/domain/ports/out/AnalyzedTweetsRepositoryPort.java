package com.appgate.coderefactoring.record.domain.ports.out;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;

public interface AnalyzedTweetsRepositoryPort {
    void save(AnalyzedTweets analyzedTweets);
}
