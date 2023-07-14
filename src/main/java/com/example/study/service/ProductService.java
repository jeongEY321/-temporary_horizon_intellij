package com.example.study.service;

import com.example.study.entity.Basket;
import com.example.study.repository.BasketRepository;
import com.example.study.repository.ShopProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final BasketRepository basketRepository;
    private final ShopProductRepository shopProductRepository;

    private Basket getBasket(String userName) {

        Basket basket = basketRepository.findByProducts(userName).orElseThrow(
                () -> new RuntimeException("정보가 업없습니다.")
        );

        return basket;
    }



}
