package com.example.todaywhereserver.domain.auth.presentation.dto;

import com.example.todaywhereserver.domain.auth.presentation.dto.request.UserLoginRequest;
import com.example.todaywhereserver.domain.auth.presentation.dto.response.TokenResponse;
import com.example.todaywhereserver.domain.auth.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserLoginService userLoginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request){
        return userLoginService.execute(request);
    }
}
