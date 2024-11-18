package com.appgate.coderefactoring.record.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnalyzedFbPosts {
    private double facebookScore;
    private String message;
    private String facebookAccount;
}
