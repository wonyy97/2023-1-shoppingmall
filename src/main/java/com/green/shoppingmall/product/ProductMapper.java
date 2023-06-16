package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductPicEntity;
import com.green.shoppingmall.product.model.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int insProduct(ProductEntity entity);
    int insProductPic(List<ProductPicEntity> picList);
    List<ProductVo> selProduct();
}
