package com.example.todaywhereserver.domain.travel.service;

import com.example.todaywhereserver.domain.travel.facade.TravelFacade;
import com.example.todaywhereserver.domain.travel.presentation.dto.response.TravelDetailsResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class TravelDetailsService {

    @Value("${kakao.client_id}")
    private String apiKey;

    private final TravelFacade travelFacade;
    private final RestTemplate restTemplate;


    @Transactional
    public TravelDetailsResponse execute(Long id) {
        String name = travelFacade.findById(id).getName();

        String url = "https://dapi.kakao.com/v2/local/search/keyword.json?query=" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String address = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.getBody());
            JsonNode documents = root.path("documents");
            if (documents.isArray() && documents.size() > 0) {
                address = documents.get(0).path("address_name").asText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return TravelDetailsResponse.builder()
                .address(address)
                .build();
    }
}
