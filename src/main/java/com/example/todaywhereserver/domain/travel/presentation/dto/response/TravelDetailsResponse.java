package com.example.todaywhereserver.domain.travel.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TravelDetailsResponse {
    private final String name;
}