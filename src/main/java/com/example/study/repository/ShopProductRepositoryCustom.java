package com.example.study.repository;

import com.example.study.entity.ShopProduct;

import java.util.List;

public interface ShopProductRepositoryCustom {

    List<ShopProduct> findByProduct(String productName);

}
