package com.green.shoppingmall.review.model;

import lombok.Data;

import java.util.List;

@Data
public class ReviewPicInsDto {
    private Long ireview; //1
    private List<String> pics; //a.jpg, b.jpg
}