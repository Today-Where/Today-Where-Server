package com.example.todaywhereserver.domain.travel.exception;

import com.example.todaywhereserver.global.error.CustomException;
import com.example.todaywhereserver.global.error.ErrorCode;

public class TravelNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new TravelNotFoundException();

    private TravelNotFoundException() {
        super(ErrorCode.TRAVEL_NOT_FOUND);
    }
}
