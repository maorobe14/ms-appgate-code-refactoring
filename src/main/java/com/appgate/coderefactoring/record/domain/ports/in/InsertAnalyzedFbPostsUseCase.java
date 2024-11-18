package com.appgate.coderefactoring.record.domain.ports.in;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;

public interface InsertAnalyzedFbPostsUseCase {
    void insertAnalyzedFbPosts(AnalyzedFbPosts analyzedFbPosts);
}
