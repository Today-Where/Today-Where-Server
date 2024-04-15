package com.example.todaywhereserver.domain.survey.service;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import com.example.todaywhereserver.domain.survey.facade.SurveyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SurveyListService {
    private final SurveyFacade surveyFacade;

    @Transactional
    public Iterable<Survey> execute() {
        return surveyFacade.findAll();
    }
}
