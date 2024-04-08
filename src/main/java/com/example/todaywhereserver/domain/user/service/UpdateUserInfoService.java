package com.example.todaywhereserver.domain.user.service;

import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import com.example.todaywhereserver.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateUserInfoRequest request) {
        User user = userFacade.getCurrentUser();
        user.update(request.getEmail(), request.getAge(), request.getSex());
    }
}