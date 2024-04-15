package com.example.todaywhereserver.domain.survey.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class SurveyNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new SurveyNotFoundException();

    private SurveyNotFoundException() {
        super(ErrorCode.SURVEY_NOT_FOUND);
    }
}
