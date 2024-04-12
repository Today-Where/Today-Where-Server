package com.example.todaywhereserver.domain.keyword.service;

import com.example.todaywhereserver.domain.keyword.domain.Keyword;
import com.example.todaywhereserver.domain.keyword.facade.KeywordFacade;
import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteKeywordService {
    private final KeywordFacade keywordFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id){
        Keyword keyword = keywordFacade.findById(id);

        User user = userFacade.getCurrentUser();

        user.deleteKeyword(keyword);
    }
}
