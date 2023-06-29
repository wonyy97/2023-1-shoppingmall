package com.green.shoppingmall.buy.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BuyVo {
    private Long ibuy;
    private Long iproduct;
    private Long icustomer;
    private int quantity;
    private String buyAt;
    private String productNm;
    private int productPrice;
    private String productMainPic;
    private String customerNm;
}