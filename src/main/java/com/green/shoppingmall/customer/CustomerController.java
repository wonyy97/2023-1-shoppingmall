package com.green.shoppingmall.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    /customer 고객
    (post) 회원가입

 */



@RestController
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }
}
