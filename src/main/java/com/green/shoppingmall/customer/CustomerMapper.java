package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    int insCustomer(CustomerInsDto dto);
}
