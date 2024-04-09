package com.example.todaywhereserver.domain.auth.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24 * 7)
public class RefreshToken {

    @Id
    private String email;

    @Indexed
    private String token;

    @TimeToLive
    private Long ttl;

    public void updateToken(String token, Long ttl){
        this.token = token;
        this.ttl = ttl;
    }
}
