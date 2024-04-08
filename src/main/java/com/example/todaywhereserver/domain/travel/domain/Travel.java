package com.example.todaywhereserver.domain.travel.domain;

import com.example.todaywhereserver.global.entity.BaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Getter
@NoArgsConstructor
@Entity
public class Travel extends BaseIdEntity {

    @Column(length = 100, nullable = false)
    private String name;
}
