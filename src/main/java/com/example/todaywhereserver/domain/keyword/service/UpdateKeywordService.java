package com.example.todaywhereserver.domain.keyword.service;

import com.example.todaywhereserver.domain.keyword.domain.Keyword;
import com.example.todaywhereserver.domain.keyword.domain.repository.KeywordRepository;
import com.example.todaywhereserver.domain.keyword.facade.KeywordFacade;
import com.example.todaywhereserver.domain.keyword.presentation.dto.request.UpdateKeywordRequest;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateKeywordService {
    private final KeywordRepository keywordRepository;
    private final KeywordFacade keywordFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, UpdateKeywordRequest request) {
        Keyword keyword = keywordFacade.findById(id);

        userFacade.checkWriter(keyword);

        keyword.update(request.getKeyword());
    }
}
