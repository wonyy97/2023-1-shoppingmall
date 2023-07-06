package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.ReviewEntity;
import com.green.shoppingmall.review.model.ReviewPicInsDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReviewMapper {
    int insReview(ReviewEntity p);
    int insReviewPics(ReviewPicInsDto p);
}