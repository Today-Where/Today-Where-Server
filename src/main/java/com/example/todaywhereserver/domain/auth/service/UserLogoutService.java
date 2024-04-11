package com.example.todaywhereserver.domain.auth.service;

import com.example.todaywhereserver.domain.auth.domain.RefreshToken;
import com.example.todaywhereserver.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.todaywhereserver.global.exception.InvalidRefreshTokenException;
import com.example.todaywhereserver.global.exception.RefreshTokenNotFoundException;
import com.example.todaywhereserver.global.security.jwt.JwtTokenResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLogoutService {
    private final JwtTokenResolver jwtTokenResolver;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute(String refreshToken) {
        String parseToken = jwtTokenResolver.parseToken(refreshToken);

        if(parseToken == null) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(parseToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(redisRefreshToken);
    }
}
