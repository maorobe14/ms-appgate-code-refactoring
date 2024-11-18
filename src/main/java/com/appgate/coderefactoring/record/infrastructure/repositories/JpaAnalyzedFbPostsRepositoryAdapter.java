package com.appgate.coderefactoring.record.infrastructure.repositories;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.ports.out.AnalyzedFbPostsRepositoryPort;
import com.appgate.coderefactoring.record.infrastructure.mapper.AnalyzedFbPostsMapper;
import org.springframework.stereotype.Component;

@Component
public class JpaAnalyzedFbPostsRepositoryAdapter implements AnalyzedFbPostsRepositoryPort {

    private final JpaAnalyzedFbPostsRepository jpaAnalyzedFbPostsRepository;
    private final AnalyzedFbPostsMapper analyzedFbPostsMapper;

    public JpaAnalyzedFbPostsRepositoryAdapter(JpaAnalyzedFbPostsRepository jpaAnalyzedFbPostsRepository, AnalyzedFbPostsMapper analyzedFbPostsMapper) {
        this.jpaAnalyzedFbPostsRepository = jpaAnalyzedFbPostsRepository;
        this.analyzedFbPostsMapper = analyzedFbPostsMapper;
    }

    @Override
    public void save(AnalyzedFbPosts analyzedFbPosts) {
        jpaAnalyzedFbPostsRepository.save(analyzedFbPostsMapper.toEntity(analyzedFbPosts));
    }
}
