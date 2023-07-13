package com.example.study.entity;

import lombok.*;

import javax.persistence.*;

@Setter @Getter @ToString(exclude = "basket")
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "shop_product")
public class ShopProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String productName; //재품 이름

    private int inventoryCount; //재고 개수

    private String productContent; //재품 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    private Basket basket;


}

