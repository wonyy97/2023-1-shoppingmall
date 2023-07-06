package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.ReviewInsDto;
import com.green.shoppingmall.review.model.ReviewSelDto;
import com.green.shoppingmall.review.model.ReviewVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping
    public ResponseEntity<Integer> postReview(ReviewInsDto dto) {
        log.info("[(post) /review] dto: {}", dto);
        return ResponseEntity.ok(service.insReview(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReviewVo>> getReview(@RequestParam Long iproduct) {
        ReviewSelDto dto = new ReviewSelDto();
        dto.setIproduct(iproduct);
        return ResponseEntity.ok(service.selReview(dto));
    }
}