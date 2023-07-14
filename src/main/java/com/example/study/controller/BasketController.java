package com.example.study.controller;


import com.example.study.entity.Basket;
import com.example.study.response.ProductListReponse;
import com.example.study.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/shop/products")
//@CrossOrigin
@CrossOrigin(origins = "http://localhost:3000")
public class BasketController {

    private final ProductService productService;

    @GetMapping
    public Basket retrieveProductList() {

        return null;
    }




}
