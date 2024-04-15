package com.example.todaywhereserver.domain.survey.service;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import com.example.todaywhereserver.domain.survey.facade.SurveyFacade;
import com.example.todaywhereserver.domain.survey.presentation.dto.response.SurveyDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SurveyDetailsService {
    private final SurveyFacade surveyFacade;

    @Transactional
    public SurveyDetailsResponse execute(Long id) {
        Survey survey = surveyFacade.findById(id);

        return SurveyDetailsResponse.builder()
                .content(survey.getContent())
                .build();
    }
}
