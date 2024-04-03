package com.example.todaywhereserver.domain.travel.domain;

import com.example.todaywhereserver.global.entity.BaseIdEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Travel extends BaseIdEntity {

    @Column(length = 100, nullable = false)
    private String travel;
}
