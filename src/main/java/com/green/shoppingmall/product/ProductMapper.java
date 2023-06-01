package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int insProduct(ProductEntity entity);
}
