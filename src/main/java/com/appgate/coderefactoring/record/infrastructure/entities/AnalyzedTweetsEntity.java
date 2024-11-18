package com.appgate.coderefactoring.record.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "analyzed_tweets")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AnalyzedTweetsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double tweeterScore;
    private String message;
    private String tweeterUrl;
    private String tweeterAccount;

}
