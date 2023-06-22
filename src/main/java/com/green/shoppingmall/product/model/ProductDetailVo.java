package com.green.shoppingmall.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDetailVo {
    private Long iproduct;
    private Integer price;
    private String ctnt;
    private String nm;
    private String mainPic;
    private String brand;
}
