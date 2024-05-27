package com.example.todaywhereserver.domain.survey.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SurveyAnswerResponse {
    private final String name;

    private final String content;

    private final String address;
}
