package com.example.todaywhereserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),
    WRITER_MISMATCH(401, "Writer Mismatch"),
    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    KEYWORD_NOT_FOUND(404, "Keyword Not Found"),
    USER_NOT_FOUND(404, "User Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),

    USER_EXIST(409, "user Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}