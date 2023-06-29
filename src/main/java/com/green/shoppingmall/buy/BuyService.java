package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyEntity;
import com.green.shoppingmall.buy.model.BuyInsDto;
import com.green.shoppingmall.buy.model.BuyVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j //LOGGER 만들어주는 어노테이션
@Service
@RequiredArgsConstructor
public class BuyService {
    private final BuyMapper mapper;

    public Long insBuy(BuyInsDto dto) {
        int result = mapper.insBuy(dto);
        return Long.valueOf(result);
    }

//    public List<BuyVo> selBuy(BuyEntity entity) {
//        return mapper.selBuy(entity);
//    }

    public List<BuyVo> selBuy(Long icustomer) {
        return mapper.selBuy(icustomer);
    }

}
