package com.example.todaywhereserver.domain.keyword.domain;

import com.example.todaywhereserver.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class Keyword extends BaseIdEntity {

    @Column(length = 100)
    private String keyword;

    @Builder
    public Keyword(String keyword) {
        this.keyword = keyword;
    }
}
