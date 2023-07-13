package com.example.study.repository;

import com.example.study.entity.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopProductRepository extends JpaRepository<ShopProduct, Long>, ShopProductRepositoryCustom {
}
