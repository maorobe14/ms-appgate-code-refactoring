package com.appgate.coderefactoring.record.infrastructure.repositories;

import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import com.appgate.coderefactoring.record.domain.ports.out.AnalyzedTweetsRepositoryPort;
import com.appgate.coderefactoring.record.infrastructure.mapper.AnalyzedTweetsMapper;
import org.springframework.stereotype.Component;

@Component
public class JpaAnalyzedTweetsRepositoryAdapter implements AnalyzedTweetsRepositoryPort {

    private final JpaAnalyzedTweetsRepository jpaAnalyzedTweetsRepository;
    private final AnalyzedTweetsMapper analyzedTweetsMapper;

    public JpaAnalyzedTweetsRepositoryAdapter(JpaAnalyzedTweetsRepository jpaAnalyzedTweetsRepository, AnalyzedTweetsMapper analyzedTweetsMapper) {
        this.jpaAnalyzedTweetsRepository = jpaAnalyzedTweetsRepository;
        this.analyzedTweetsMapper = analyzedTweetsMapper;
    }

    @Override
    public void save(AnalyzedTweets analyzedTweets) {
        jpaAnalyzedTweetsRepository.save(analyzedTweetsMapper.toEntity(analyzedTweets));
    }
}
