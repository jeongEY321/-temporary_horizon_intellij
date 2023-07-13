package com.example.study.repository;

import com.example.study.entity.Basket;
import com.example.study.entity.ShopProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.study.entity.QBasket.basket;
import static com.example.study.entity.QShopProduct.shopProduct;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class ShopProductRepositoryTest {

    @Autowired
    ShopProductRepository shopproductRepository;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    EntityManager em;

    JPAQueryFactory factory;

    @BeforeEach
    void settingObject() {
        factory = new JPAQueryFactory(em);
    }

//    @BeforeEach
    void testInsertData() {

        Basket userA = Basket.builder()
                .name("userA")
                .build();

        Basket userB = Basket.builder()
                .name("userB")
                .build();

        basketRepository.save(userA);
        basketRepository.save(userB);

        ShopProduct product1 = ShopProduct.builder()
                .productName("product1")
                .productContent("product1입니다.")
                .inventoryCount(5)
                .basket(userA)
                .build();
        ShopProduct product2 = ShopProduct.builder()
                .productName("product2")
                .productContent("product2입니다.")
                .inventoryCount(2)
                .basket(userA)
                .build();
        ShopProduct product3 = ShopProduct.builder()
                .productName("product3")
                .productContent("product3입니다.")
                .inventoryCount(10)
                .basket(userB)
                .build();
        ShopProduct product4 = ShopProduct.builder()
                .productName("product4")
                .productContent("product4입니다.")
                .inventoryCount(50)
                .basket(userB)
                .build();
        ShopProduct product5 = ShopProduct.builder()
                .productName("product5")
                .productContent("product5입니다.")
                .inventoryCount(5)
                .basket(userA)
                .build();
        ShopProduct product6 = ShopProduct.builder()
                .productName("product6")
                .productContent("product6입니다.")
                .inventoryCount(15)
                .basket(userA)
                .build();
        ShopProduct product7 = ShopProduct.builder()
                .productName("product7")
                .productContent("product7입니다.")
                .inventoryCount(10)
                .basket(userB)
                .build();
        ShopProduct product8 = ShopProduct.builder()
                .productName("product8")
                .productContent("product8입니다.")
                .inventoryCount(8)
                .basket(userB)
                .build();

        shopproductRepository.save(product1);
        shopproductRepository.save(product2);
        shopproductRepository.save(product3);
        shopproductRepository.save(product4);
        shopproductRepository.save(product5);
        shopproductRepository.save(product6);
        shopproductRepository.save(product7);
        shopproductRepository.save(product8);


    }

    @Test
    @DisplayName("testJPA")
    void testJPA() {
        List<ShopProduct> products = shopproductRepository.findAll();
        products.forEach(System.out::println);
    }

    @Test
    @DisplayName("JPQL")
    void testJPQL () {
        //given
        String jpqlQuery = "SELECT p FROM ShopProduct p WHERE p.productName = :productName";
        //when
        ShopProduct foundProducts = em.createQuery(jpqlQuery, ShopProduct.class)
                .setParameter("productName", "product2")
                .getSingleResult();
        //then
        assertEquals("userA", foundProducts.getBasket().getName());

        System.out.println("\n\n\n");
        System.out.println("foundProduct = " + foundProducts);
        System.out.println("foundProduct.getBasket() = " + foundProducts.getBasket());
        System.out.println("\n\n\n");
    }

    @Test
    @DisplayName("QueryDSLProduct")
    void testQueryDSLProduct() {
        //given

        //when
        List<ShopProduct> foundProducts = factory
                .selectFrom(shopProduct)
                .fetch();
        //then
        assertNotNull(foundProducts);


        System.out.println("\n\n\n");
        System.out.println("foundProducts = " + foundProducts);
        System.out.println("foundProducts.getClass() = " + foundProducts.get(0).getProductName());
        System.out.println("\n\n\n");
    }

    @Test
    @DisplayName("testQueryDSLBasket")
    void testQueryDSLBasket() {
        //given

        //when
        List<Basket> foundUser = factory.selectFrom(basket)
                .where(basket.name.eq("userA"))
                .fetch();
        //then
        assertNotNull(foundUser);

        System.out.println("\n\n\n");
        System.out.println("foundUser = " + foundUser);
        System.out.println("\n\n\n");

    }


}