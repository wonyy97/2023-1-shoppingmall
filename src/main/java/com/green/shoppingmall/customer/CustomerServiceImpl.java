package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerGetVo;
import com.green.shoppingmall.customer.model.CustomerInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int insCustomer(CustomerInsDto dto) {
        return mapper.insCustomer(dto);
    }

    public List<CustomerGetVo> selCustomer() {
        return mapper.selCustomer();
    }
}
