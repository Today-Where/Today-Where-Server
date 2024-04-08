package com.example.todaywhereserver.domain.keyword.presentation;

import com.example.todaywhereserver.domain.keyword.presentation.dto.request.AddKeywordRequest;
import com.example.todaywhereserver.domain.keyword.service.AddKeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/keyword")
@RequiredArgsConstructor
@RestController
public class KeywordController {
    private final AddKeywordService addKeywordService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addKeyword(@RequestBody @Valid AddKeywordRequest request) {
        addKeywordService.execute(request);
    }
}
