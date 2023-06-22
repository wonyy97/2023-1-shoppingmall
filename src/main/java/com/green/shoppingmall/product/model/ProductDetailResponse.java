package com.green.shoppingmall.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ProductDetailResponse {
    private ProductDetailVo data;
    private List<String> pics;
}
