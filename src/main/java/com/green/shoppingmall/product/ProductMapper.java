package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int insProduct(ProductEntity entity);
    int insProductPic(List<ProductPicEntity> picList);
    List<ProductVo> selProduct();
    ProductDetailVo selProductById(ProductGetDetailDto dto);
    List<String> selProductPics(ProductGetDetailDto dto);
}
