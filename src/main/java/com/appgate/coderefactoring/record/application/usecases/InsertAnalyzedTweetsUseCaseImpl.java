package com.appgate.coderefactoring.record.application.usecases;

import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import com.appgate.coderefactoring.record.domain.ports.in.InsertAnalyzedTweetsUseCase;
import com.appgate.coderefactoring.record.domain.ports.out.AnalyzedTweetsRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class InsertAnalyzedTweetsUseCaseImpl implements InsertAnalyzedTweetsUseCase {

    private final AnalyzedTweetsRepositoryPort analyzedTweetsRepositoryPort;

    public InsertAnalyzedTweetsUseCaseImpl(AnalyzedTweetsRepositoryPort analyzedTweetsRepositoryPort) {
        this.analyzedTweetsRepositoryPort = analyzedTweetsRepositoryPort;
    }

    @Override
    public void insertAnalyzedTweets(AnalyzedTweets analyzedTweets) {
        analyzedTweetsRepositoryPort.save(analyzedTweets);
    }
}
