package com.appgate.coderefactoring.record.infrastructure.repositories;

import com.appgate.coderefactoring.record.infrastructure.entities.AnalyzedFbPostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAnalyzedFbPostsRepository extends JpaRepository<AnalyzedFbPostsEntity, Long> {
}
