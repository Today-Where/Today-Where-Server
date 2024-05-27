package com.example.todaywhereserver.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class UserInfoResponse {
    private final String email;
    private final Integer age;
    private final String sex;
    private final List<TravelResponse> travel;
}
