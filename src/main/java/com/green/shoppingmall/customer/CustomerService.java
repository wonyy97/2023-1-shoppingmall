package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerInsDto;
import org.springframework.stereotype.Service;


public interface CustomerService {
    int insCustomer(CustomerInsDto dto);
}

