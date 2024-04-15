package com.example.todaywhereserver.domain.survey.facade;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import com.example.todaywhereserver.domain.survey.domain.repository.SurveyRepository;
import com.example.todaywhereserver.domain.survey.exception.SurveyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SurveyFacade {
    private final SurveyRepository surveyRepository;

    public Iterable<Survey> findAll() {
        return surveyRepository.findAll();
    }

    public Survey findById(Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> SurveyNotFoundException.EXCEPTION);
    }
}
