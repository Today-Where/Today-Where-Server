package com.example.todaywhereserver.domain.travel.domain;

import com.example.todaywhereserver.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
@Entity
public class Travel extends BaseIdEntity {

    @Column(length = 100, nullable = false)
    private String name;

    @NotBlank
    private String content;

    @NotBlank
    private String address;

    @Builder
    public Travel(String name, String content, String address){
        this.name = name;
        this.content = content;
        this.address = address;
    }
}
