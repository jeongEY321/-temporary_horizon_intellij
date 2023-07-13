package com.example.study.repository;

import com.example.study.entity.ShopProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.study.entity.QShopProduct.shopProduct;

@RequiredArgsConstructor
public class ShopProductRepositoryImpl implements ShopProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ShopProduct> findByProduct(String productName) {
        return queryFactory
                .selectFrom(shopProduct)
                .where(shopProduct.productName.eq(productName))
                .fetch();
    }
}
