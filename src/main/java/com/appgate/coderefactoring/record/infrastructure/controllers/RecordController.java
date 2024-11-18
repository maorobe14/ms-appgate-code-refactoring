package com.appgate.coderefactoring.record.infrastructure.controllers;

import com.appgate.coderefactoring.record.application.services.RecordService;
import com.appgate.coderefactoring.record.domain.models.AnalyzedFbPosts;
import com.appgate.coderefactoring.record.domain.models.AnalyzedTweets;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/insertAnalyzedFbPosts")
    public ResponseEntity<Void> insertAnalyzedFbPosts(@RequestBody AnalyzedFbPosts analyzedFbPosts){
        recordService.insertAnalyzedFbPosts(analyzedFbPosts);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertAnalyzedTweets")
    public ResponseEntity<Void> insertAnalyzedTweets(@RequestBody AnalyzedTweets analyzedTweets){
        recordService.insertAnalyzedTweetsUseCase(analyzedTweets);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
