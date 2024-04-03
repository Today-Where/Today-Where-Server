package com.example.todaywhereserver.global.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}