package com.appgate.coderefactoring.socialmention.infrastructure.controllers;

import com.appgate.coderefactoring.socialmention.application.services.SocialMentionService;
import com.appgate.coderefactoring.socialmention.domain.ports.in.SocialNetworkPort;
import com.appgate.coderefactoring.socialmention.infrastructure.factory.SocialNetworkFactory;
import com.appgate.coderefactoring.socialmention.infrastructure.models.SocialMention;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SocialMentionEvaluatorController {

    @Autowired
    private SocialMentionService taskServices;

    @Autowired
    SocialNetworkFactory socialNetworkFactory;

    @PostMapping(value = "/AnalyzeSocialMention", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> socialMentionsEvaluator(@Valid @RequestBody SocialMention socialMention){
        return new ResponseEntity<String>(taskServices.EvaluateSocialMentions(socialNetworkFactory.createSocialNetworkPort(socialMention)), HttpStatus.OK);
    }
}
