package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyEntity;
import com.green.shoppingmall.buy.model.BuyInsDto;
import com.green.shoppingmall.buy.model.BuyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
    int insBuy(BuyInsDto dto);
    List<BuyVo> selBuy(Long icustomer);
}
