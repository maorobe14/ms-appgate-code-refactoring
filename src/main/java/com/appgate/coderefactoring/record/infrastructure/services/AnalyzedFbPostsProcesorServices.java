package com.appgate.coderefactoring.record.infrastructure.services;

import com.appgate.coderefactoring.record.application.services.RecordService;
import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import org.springframework.stereotype.Service;

@Service
public class AnalyzedFbPostsProcesorServices {

    private final RecordService recordService;

     public AnalyzedFbPostsProcesorServices(RecordService recordService) {
        this.recordService = recordService;
    }

    public void processAnalyzedFbPostEvent(AnalyzedFbPosts analyzedFbPosts) {
        recordService.insertAnalyzedFbPosts(analyzedFbPosts);
    }
}
