package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.ReviewInsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @PostMapping
    public ResponseEntity<Integer> postReview(ReviewInsDto dto) {
        log.info("[(post) /review] dto: {}", dto);
        return ResponseEntity.ok(1);
    }
}
