package com.example.study.response;

import com.example.study.entity.ShopProduct;
import lombok.*;

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ProductDetailResponse {

    private String productName; //재품 이름
    private int inventoryCount; //재고 개수
    private String productContent; //재품 설명

    public ProductDetailResponse(ShopProduct product) {
        this.productName = product.getProductName();
        this.inventoryCount = product.getInventoryCount();
        this.productContent = product.getProductContent();
    }

}
