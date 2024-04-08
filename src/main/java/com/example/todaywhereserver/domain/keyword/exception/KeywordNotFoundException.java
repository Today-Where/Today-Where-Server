package com.example.todaywhereserver.domain.keyword.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class KeywordNotFoundException extends CustomException {
    public final static CustomException EXCEPTION = new KeywordNotFoundException();

    private KeywordNotFoundException() {
        super(ErrorCode.KEYWORD_NOT_FOUND);
    }
}
