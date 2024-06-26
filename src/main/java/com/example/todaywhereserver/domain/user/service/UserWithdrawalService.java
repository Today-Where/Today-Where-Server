package com.example.todaywhereserver.domain.user.service;

import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.domain.repository.UserRepository;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserWithdrawalService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        userRepository.delete(user);
    }
}
