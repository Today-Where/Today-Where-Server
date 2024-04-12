package com.example.todaywhereserver.domain.keyword.service;

import com.example.todaywhereserver.domain.keyword.presentation.dto.response.QueryKeywordResponse;
import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class QuerykeywordService {
    private final UserFacade userFacade;

    @Transactional
    public QueryKeywordResponse execute(){
        User user = userFacade.getCurrentUser();

        return QueryKeywordResponse.builder()
                .keyword(user.getKeyword())
                .build();
    }
}
