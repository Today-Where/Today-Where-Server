package com.example.todaywhereserver.domain.keyword.service;

import com.example.todaywhereserver.domain.keyword.domain.Keyword;
import com.example.todaywhereserver.domain.keyword.domain.repository.KeywordRepository;
import com.example.todaywhereserver.domain.keyword.facade.KeywordFacade;
import com.example.todaywhereserver.domain.keyword.presentation.dto.request.AddKeywordRequest;
import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.domain.repository.UserRepository;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddKeywordService {
    private final KeywordRepository keywordRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final KeywordFacade keywordFacade;

    @Transactional
    public void execute(AddKeywordRequest request) {

        User user = userFacade.getCurrentUser();

        for (String keywords : request.getKeyword()) {
            keywordRepository.save(Keyword.builder()
                    .keyword(keywords)
                    .build());

            Keyword keyword = keywordFacade.findByKeyword(keywords);

            user.getKeyword().add(keyword);

            userRepository.save(user);
        }
    }
}
