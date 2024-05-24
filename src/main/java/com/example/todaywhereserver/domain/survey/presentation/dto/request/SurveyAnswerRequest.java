package com.example.todaywhereserver.domain.survey.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SurveyAnswerRequest {
    private String[] keyword;
}
