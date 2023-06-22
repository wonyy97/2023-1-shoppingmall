package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerGetVo;
import com.green.shoppingmall.customer.model.CustomerInsDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    int insCustomer(CustomerInsDto dto);
    List<CustomerGetVo> selCustomer();
}

