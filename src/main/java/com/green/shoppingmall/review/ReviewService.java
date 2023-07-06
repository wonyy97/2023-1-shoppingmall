package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.*;
import com.green.shoppingmall.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper mapper;

    @Value("${file.dir}")
    private String FILE_DIR;

    public int insReview(ReviewInsDto dto) {
        ReviewEntity entity = new ReviewEntity();
        entity.setIbuy(dto.getIbuy());
        entity.setCtnt(dto.getCtnt());
        entity.setStar(dto.getStar());

        int reviewResult = mapper.insReview(entity);
        if(reviewResult == 0) { return 0; }

        String dicPath = String.format("%s/review/%d", FILE_DIR, entity.getIreview());
        File dicFile = new File(dicPath);
        if(!dicFile.exists()) {
            dicFile.mkdirs();
        }
        ReviewPicInsDto picDto = new ReviewPicInsDto();
        picDto.setIreview(entity.getIreview());
        List<String> pics = new ArrayList<>();
        picDto.setPics(pics);

        for(MultipartFile file : dto.getPics()) {
            String saveFileNm = FileUtils.makeRandomFileNm(file.getOriginalFilename());
            String savePath = String.format("%s/%s", FileUtils.getAbsolutePath(dicPath), saveFileNm);

            File saveFile = new File(savePath);
            try {
                file.transferTo(saveFile);
                pics.add(saveFileNm);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int reviewPicResult = mapper.insReviewPics(picDto);
        return 1;
    }

    public List<ReviewVo> selReview(ReviewSelDto dto) {
        return mapper.selReview(dto);
    }
}