package com.example.todaywhereserver.domain.user.presentation;

import com.example.todaywhereserver.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.todaywhereserver.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.todaywhereserver.domain.user.presentation.dto.request.UserWithdrawalRequest;
import com.example.todaywhereserver.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.todaywhereserver.domain.user.service.UserInfoService;
import com.example.todaywhereserver.domain.user.service.UpdateUserInfoService;
import com.example.todaywhereserver.domain.user.service.UserSignupService;
import com.example.todaywhereserver.domain.user.service.UserWithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserSignupService userSignupService;
    private final UserInfoService userInfoService;
    private final UpdateUserInfoService updateUserInfoService;
    private final UserWithdrawalService userWithdrawalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signup(@RequestBody @Valid UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @GetMapping("/profile")
    public UserInfoResponse userInfo() {
        return userInfoService.execute();
    }

    @PatchMapping("profile")
    public void userInfoUpdate(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }

    @DeleteMapping
    public void userWithdrawal(@RequestBody @Valid UserWithdrawalRequest request) {
        userWithdrawalService.execute(request);
    }
}
