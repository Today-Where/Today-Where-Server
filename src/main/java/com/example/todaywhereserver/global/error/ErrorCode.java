package com.example.todaywhereserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),

    USER_EXIST(409, "유저가 존재합니다."),

    INTERNAL_SERVER_ERROR(500, "서버 내부의 에러입니다.");

    private final int status;
    private final String message;
}