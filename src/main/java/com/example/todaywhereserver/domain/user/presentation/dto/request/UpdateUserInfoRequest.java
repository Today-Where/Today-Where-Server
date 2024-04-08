package com.example.todaywhereserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {
    @Email(message = "email 형식에 맞춰주세요")
    private String email;

    private Integer age;

    private String sex;
}
