package com.example.todaywhereserver.global.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}
