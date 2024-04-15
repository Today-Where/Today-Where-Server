package com.example.todaywhereserver.domain.travel.facade;

import com.example.todaywhereserver.domain.travel.domain.Travel;
import com.example.todaywhereserver.domain.travel.domain.TravelRepository;
import com.example.todaywhereserver.domain.travel.exception.TravelNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TravelFacade {
    private final TravelRepository travelRepository;

    public Travel findById(Long id) {
        return travelRepository.findById(id)
                .orElseThrow(() -> TravelNotFoundException.EXCEPTION);
    }
}
