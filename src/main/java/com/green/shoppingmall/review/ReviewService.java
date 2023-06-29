package com.green.shoppingmall.review;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper mapper;
}
