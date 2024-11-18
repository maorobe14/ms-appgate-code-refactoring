package com.appgate.coderefactoring.record.infrastructure.mapper;

import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.infrastructure.entities.AnalyzedFbPostsEntity;
import com.appgate.coderefactoring.record.infrastructure.entities.AnalyzedTweetsEntity;
import org.springframework.stereotype.Component;

@Component
public class AnalyzedFbPostsMapper {
    public AnalyzedFbPostsEntity toEntity(AnalyzedFbPosts analyzedFbPosts){

        if (analyzedFbPosts == null) return null;

        AnalyzedFbPostsEntity analyzedFbPostsEntity = new AnalyzedFbPostsEntity();
        analyzedFbPostsEntity.setMessage(analyzedFbPosts.getMessage());
        analyzedFbPostsEntity.setFacebookScore(analyzedFbPosts.getFacebookScore());
        analyzedFbPostsEntity.setFacebookAccount(analyzedFbPosts.getFacebookAccount());

        return analyzedFbPostsEntity;
    }
}
