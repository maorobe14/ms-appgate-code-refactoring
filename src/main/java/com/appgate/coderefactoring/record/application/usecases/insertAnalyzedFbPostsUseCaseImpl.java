package com.appgate.coderefactoring.record.application.usecases;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.ports.in.InsertAnalyzedFbPostsUseCase;
import com.appgate.coderefactoring.record.domain.ports.out.AnalyzedFbPostsRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class insertAnalyzedFbPostsUseCaseImpl implements InsertAnalyzedFbPostsUseCase {

    private final AnalyzedFbPostsRepositoryPort analyzedFbPostsRepositoryPort;

    public insertAnalyzedFbPostsUseCaseImpl(AnalyzedFbPostsRepositoryPort analyzedFbPostsRepositoryPort) {
        this.analyzedFbPostsRepositoryPort = analyzedFbPostsRepositoryPort;
    }

    @Override
    public void insertAnalyzedFbPosts(AnalyzedFbPosts analyzedFbPosts) {
        analyzedFbPostsRepositoryPort.save(analyzedFbPosts);
    }
}
