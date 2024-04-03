package com.example.todaywhereserver.global.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}