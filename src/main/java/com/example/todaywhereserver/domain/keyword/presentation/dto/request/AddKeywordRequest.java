package com.example.todaywhereserver.domain.keyword.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class AddKeywordRequest {
    private List<String> keyword;
}
