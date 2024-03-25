package com.example.todaywhereserver.domain.user.domain;

import com.example.todaywhereserver.domain.travel.domain.Travel;
import com.example.todaywhereserver.global.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public User(String email, String password, Integer age, String sex, List<Travel> travel) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.travel = travel;
    }
}
