package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyEntity;
import com.green.shoppingmall.buy.model.BuyInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyMapper {
    int insBuy(BuyInsDto dto);
}
