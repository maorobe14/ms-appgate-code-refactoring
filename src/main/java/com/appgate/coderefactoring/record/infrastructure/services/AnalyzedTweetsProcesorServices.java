package com.appgate.coderefactoring.record.infrastructure.services;

import com.appgate.coderefactoring.record.application.services.RecordService;
import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import org.springframework.stereotype.Service;

@Service
public class AnalyzedTweetsProcesorServices {
    private final RecordService recordService;

    public AnalyzedTweetsProcesorServices(RecordService recordService) {
        this.recordService = recordService;
    }

    public void processAnalyzedTweetsEvent(AnalyzedTweets eventAnalyzedTweets) {
        recordService.insertAnalyzedTweets(eventAnalyzedTweets);
    }
}
