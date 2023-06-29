package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerGetVo;
import com.green.shoppingmall.customer.model.CustomerInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        int result = service.insCustomer(dto);
        return ResponseEntity.ok(result);
        //return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<CustomerGetVo>> getCustomer() {
        return ResponseEntity.ok(service.selCustomer());
    }
}
