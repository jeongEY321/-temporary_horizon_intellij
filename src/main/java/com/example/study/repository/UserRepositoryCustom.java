package com.example.study.repository;

import com.example.study.entity.User;

import java.util.Optional;

public interface UserRepositoryCustom {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
