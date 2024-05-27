package com.example.todaywhereserver.domain.travel.service;

import com.example.todaywhereserver.domain.travel.domain.Travel;
import com.example.todaywhereserver.domain.travel.facade.TravelFacade;
import com.example.todaywhereserver.domain.travel.presentation.dto.response.TravelDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TravelDetailsService {
    private final TravelFacade travelFacade;

    @Transactional
    public TravelDetailsResponse execute(Long id) {
        Travel travel = travelFacade.findById(id);

        return TravelDetailsResponse.builder()
                .name(travel.getName())
                .description(travel.getDescription())
                .address(travel.getAddress())
                .build();
    }
}
