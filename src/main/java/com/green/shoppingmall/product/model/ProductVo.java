package com.green.shoppingmall.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@AllArgsConstructor
public class ProductVo {
    private Long iproduct;
    private Integer price;
    private String nm;
    private String mainPic;
    private String brand;
}
