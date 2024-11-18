package com.appgate.coderefactoring.record.domain.ports.out;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;

public interface AnalyzedFbPostsRepositoryPort {
    void save(AnalyzedFbPosts analyzedFbPosts);
}
