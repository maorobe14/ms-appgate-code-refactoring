package com.appgate.coderefactoring.record.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "analyzed_fb_posts")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AnalyzedFbPostsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double facebookScore;
    private String message;
    private String facebookAccount;
}
