package com.example.study.response;

import lombok.*;

import java.util.List;

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ProductListReponse {

    private String error;

    private List<ProductDetailResponse> products;

}
