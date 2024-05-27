package com.example.todaywhereserver.global.security;

import com.example.todaywhereserver.global.security.jwt.FilterConfig;
import com.example.todaywhereserver.global.security.jwt.JwtTokenResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenResolver jwtTokenResolver;
    private final ObjectMapper objectMapper;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/tokens").permitAll()
                .antMatchers(HttpMethod.PATCH, "/auth/tokens").permitAll()

                .antMatchers(HttpMethod.GET, "/**").permitAll()

                .anyRequest().authenticated()

                .and()
                .apply(new FilterConfig(jwtTokenResolver, objectMapper))
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
