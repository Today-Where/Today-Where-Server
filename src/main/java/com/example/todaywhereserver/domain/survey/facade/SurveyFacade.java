package com.example.todaywhereserver.domain.survey.facade;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import com.example.todaywhereserver.domain.survey.domain.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SurveyFacade {
    private final SurveyRepository surveyRepository;

    public Iterable<Survey> findAll() {
        return surveyRepository.findAll();
    }
}
