package com.green.shoppingmall.review.model;

import lombok.Data;

import java.util.List;

@Data
public class ReviewVo {
    private Long ireview;
    private String buyerNm;
    private int star;
    private String createdAt;
    private String ctnt;
    private String productNm;
    private List<String> pics;
}