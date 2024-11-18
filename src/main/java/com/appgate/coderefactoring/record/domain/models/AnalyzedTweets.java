package com.appgate.coderefactoring.record.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnalyzedTweets {
    private double tweeterScore;
    private String message;
    private String tweeterUrl;
    private String tweeterAccount;
}
