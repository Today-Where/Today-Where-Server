package com.example.todaywhereserver.domain.survey.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class SurveyDetailsResponse {
    private final String content;
}
