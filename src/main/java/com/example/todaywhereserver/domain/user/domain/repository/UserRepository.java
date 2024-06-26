package com.example.todaywhereserver.domain.user.domain.repository;


import com.example.todaywhereserver.domain.keyword.domain.Keyword;
import com.example.todaywhereserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String accountId);
    Optional<User> findByKeyword(Keyword keyword);
}
