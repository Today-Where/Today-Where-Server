package com.example.todaywhereserver.domain.keyword.presentation.dto.response;

import com.example.todaywhereserver.domain.keyword.domain.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class QueryKeywordResponse {

    private final List<Keyword> keyword;
}
