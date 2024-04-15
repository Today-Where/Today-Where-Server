package com.example.todaywhereserver.domain.survey.presentation;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import com.example.todaywhereserver.domain.survey.presentation.dto.response.SurveyDetailsResponse;
import com.example.todaywhereserver.domain.survey.service.SurveyDetailsService;
import com.example.todaywhereserver.domain.survey.service.SurveyListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/survey")
@RequiredArgsConstructor
@RestController
public class SurveyController {
    private final SurveyListService surveyListService;
    private final SurveyDetailsService surveyDetailsService;

    @GetMapping
    public Iterable<Survey> surveyList() {
        return surveyListService.execute();
    }

    @GetMapping("/{id}")
    public SurveyDetailsResponse surveyDetails(@PathVariable("id") Long id) {
        return surveyDetailsService.execute(id);
    }
}
