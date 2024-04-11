package com.example.todaywhereserver.domain.auth.presentation;

import com.example.todaywhereserver.domain.auth.presentation.dto.request.UserLoginRequest;
import com.example.todaywhereserver.domain.auth.presentation.dto.response.TokenResponse;
import com.example.todaywhereserver.domain.auth.service.TokenRefreshService;
import com.example.todaywhereserver.domain.auth.service.UserLoginService;
import com.example.todaywhereserver.domain.auth.service.UserLogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserLoginService userLoginService;
    private final TokenRefreshService tokenRefreshService;
    private final UserLogoutService userLogoutService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/tokens")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request){
        return userLoginService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/tokens")
    public TokenResponse refresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/logout")
    public void logout(@RequestHeader("Refresh-Token") String refreshToken){
        userLogoutService.execute(refreshToken);
    }
}
