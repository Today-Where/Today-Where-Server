package com.example.todaywhereserver.domain.user.presentation;

import com.example.todaywhereserver.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.todaywhereserver.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid UserSignupRequest request) {
        userSignupService.execute(request);
    }
}
