package com.example.todaywhereserver.domain.user.domain;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import com.example.todaywhereserver.domain.travel.domain.Travel;
import com.example.todaywhereserver.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseIdEntity {

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @NotNull
    private Integer age;

    @Column(length = 3, nullable = false)
    private String sex;

    @OneToMany
    private List<Travel> travel;

    @OneToMany
    private List<Survey> survey;

    @Builder
    public User(String email, String password, Integer age, String sex, List<Travel> travel, List<Survey> survey) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.travel = travel;
        this.survey = survey;
    }
}
