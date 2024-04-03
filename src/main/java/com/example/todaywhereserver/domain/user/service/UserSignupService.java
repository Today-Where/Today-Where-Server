package com.example.todaywhereserver.domain.user.service;

import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.domain.repository.UserRepository;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import com.example.todaywhereserver.domain.user.presentation.dto.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserSignupRequest request) {
        userFacade.checkUserExist(request.getEmail());

        userRepository.save(User.builder()
                .email(request.getEmail())
                .age(request.getAge())
                .sex(request.getSex())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }

}
