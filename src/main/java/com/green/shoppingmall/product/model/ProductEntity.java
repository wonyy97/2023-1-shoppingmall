package com.green.shoppingmall.product.model;

import lombok.Data;

@Data
public class ProductEntity {
    private Long iproduct;
    private Integer price;
    private String ctnt;
    private String nm;
    private String mainPic;
    private String brand;
    private String createdAt;

}
