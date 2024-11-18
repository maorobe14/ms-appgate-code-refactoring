package com.appgate.coderefactoring.record.infrastructure.mapper;

import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import com.appgate.coderefactoring.record.infrastructure.entities.AnalyzedTweetsEntity;
import com.appgate.coderefactoring.record.infrastructure.repositories.JpaAnalyzedTweetsRepository;
import org.springframework.stereotype.Component;

@Component
public class AnalyzedTweetsMapper {

    public AnalyzedTweetsEntity toEntity(AnalyzedTweets analyzedTweets){

        if (analyzedTweets == null) return null;

        AnalyzedTweetsEntity analyzedTweetsEntity = new AnalyzedTweetsEntity();
        analyzedTweetsEntity.setMessage(analyzedTweets.getMessage());
        analyzedTweetsEntity.setTweeterAccount(analyzedTweets.getTweeterAccount());
        analyzedTweetsEntity.setTweeterScore(analyzedTweets.getTweeterScore());
        analyzedTweetsEntity.setTweeterUrl(analyzedTweets.getTweeterUrl());

        return analyzedTweetsEntity;
    }

}
