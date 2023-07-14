package com.example.study.repository;

import com.example.study.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    //회원 이름으로 회원정보 조회
    Optional<Basket> findByProducts(String name);

}
