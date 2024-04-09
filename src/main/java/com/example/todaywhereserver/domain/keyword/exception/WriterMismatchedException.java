package com.example.todaywhereserver.domain.keyword.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class WriterMismatchedException extends CustomException {
    public static final CustomException EXCEPTION = new WriterMismatchedException();

    private WriterMismatchedException() {
        super(ErrorCode.WRITER_MISMATCH);
    }
}
