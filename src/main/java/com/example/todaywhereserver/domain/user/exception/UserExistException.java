package com.example.todaywhereserver.domain.user.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class UserExistException extends CustomException {
    public static final CustomException EXCEPTION = new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}
