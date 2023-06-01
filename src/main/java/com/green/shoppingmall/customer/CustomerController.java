package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    /customer 고객
    (post) 회원가입

 */


@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> postCustomer(@RequestBody CustomerInsDto dto) {
        int result =  service.insCustomer(dto);
        return ResponseEntity.ok(result);  //나이스한 응답 200번
//        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
