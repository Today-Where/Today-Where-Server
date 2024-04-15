package com.example.todaywhereserver.domain.travel.presentation;

import com.example.todaywhereserver.domain.travel.presentation.dto.response.TravelDetailsResponse;
import com.example.todaywhereserver.domain.travel.service.TravelDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/travel")
@RequiredArgsConstructor
@RestController
public class TravelController {
    private final TravelDetailsService travelDetailsService;

    @GetMapping("/{id}")
    public TravelDetailsResponse travelDetails(@PathVariable("id") Long id) {
        return travelDetailsService.execute(id);
    }
}
