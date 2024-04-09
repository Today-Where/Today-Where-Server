package com.example.todaywhereserver.domain.keyword.facade;

import com.example.todaywhereserver.domain.keyword.domain.Keyword;
import com.example.todaywhereserver.domain.keyword.domain.repository.KeywordRepository;
import com.example.todaywhereserver.domain.keyword.exception.KeywordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KeywordFacade {
    private final KeywordRepository keywordRepository;

    public Keyword findByKeyword(String keyword) {
        return keywordRepository.findByKeyword(keyword)
                .orElseThrow(() -> KeywordNotFoundException.EXCEPTION);
    }

    public Keyword findById(Long id) {
        return keywordRepository.findById(id)
                .orElseThrow(() -> KeywordNotFoundException.EXCEPTION);
    }
}
