package com.example.todaywhereserver.domain.user.service;

import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import com.example.todaywhereserver.domain.user.presentation.dto.response.TravelResponse;
import com.example.todaywhereserver.domain.user.presentation.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserFacade userFacade;

    @Transactional
    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();

        List<TravelResponse> travelResponses = user.getTravel().stream()
                .map(travel -> new TravelResponse(travel.getId(), travel.getName()))
                .collect(Collectors.toList());

        return UserInfoResponse.builder()
                .email(user.getEmail())
                .age(user.getAge())
                .sex(user.getSex())
                .travel(travelResponses)
                .build();
    }
}
