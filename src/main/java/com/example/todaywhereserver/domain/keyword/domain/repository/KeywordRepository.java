package com.example.todaywhereserver.domain.keyword.domain.repository;

import com.example.todaywhereserver.domain.keyword.domain.Keyword;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KeywordRepository extends CrudRepository<Keyword, Long> {
    Optional<Keyword> findByKeyword(String keyword);
}
