package com.appgate.coderefactoring.record.infrastructure.repositories;

import com.appgate.coderefactoring.record.infrastructure.entities.AnalyzedTweetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAnalyzedTweetsRepository extends JpaRepository<AnalyzedTweetsEntity,Long> {
}
