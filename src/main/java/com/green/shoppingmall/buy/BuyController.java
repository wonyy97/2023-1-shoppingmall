package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyInsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/buy")
@RequiredArgsConstructor
public class BuyController {
    private final BuyService service;

    @PostMapping
    public ResponseEntity<Long> postBuy(@RequestBody BuyInsDto dto) {
        return ResponseEntity.ok(service.insBuy(dto));
    }




}
