package com.example.todaywhereserver.domain.survey.domain;

import com.example.todaywhereserver.global.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Survey extends BaseIdEntity {

    @Column(length = 100, nullable = false)
    private String content;
}
