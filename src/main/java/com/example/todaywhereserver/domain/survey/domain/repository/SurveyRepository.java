package com.example.todaywhereserver.domain.survey.domain.repository;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
}
