package com.green.shoppingmall.review.model;

import lombok.Data;

@Data
public class ReviewEntity {
    private Long ireview;
    private Long ibuy;
    private String ctnt;
    private int star;
    private String createdAt;
}