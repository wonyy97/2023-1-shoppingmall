package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.*;
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
public class ProductService {

    private final ProductMapper mapper;

    @Value("${file.dir}")
    private String fileDir;


    public int insProduct(MultipartFile img, ProductInsDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setPrice(dto.getPrice());
        entity.setCtnt(dto.getCtnt());
        entity.setNm(dto.getNm());
        entity.setBrand(dto.getBrand());

        //랜덤한 파일명 만든다
        String savedFileNm = FileUtils.makeRandomFileNm(img.getOriginalFilename());

        // insert 한다
        entity.setMainPic(savedFileNm);
        System.out.println("savedFileNm : " + savedFileNm);
        int result = mapper.insProduct(entity);

        //pk값 얻었다
        System.out.println("result : " + result);
        System.out.println("pk : " + entity.getIproduct());

        //폴더 생성
        String targetDic = String.format("%s/product/%d", fileDir, entity.getIproduct());
        File fileTargetDir = new File(targetDic);

        if (!fileTargetDir.exists()) {
            fileTargetDir.mkdirs(); //파일 만들어주는 메소드 mkdirs
        }

        //이미지를 해당 폴더로 이동 시키기
        File fileTarget = new File(targetDic + "/" + savedFileNm);

        try {
            img.transferTo(fileTarget);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public Long insProductPics(Long iproduct, List<MultipartFile> pics) throws Exception {

        // pk > pics 폴더를 만든다.
        String targetDir = String.format("%s/product/%d/pics", fileDir, iproduct);
        File fileTargetDir = new File(targetDir);
        if (!fileTargetDir.exists()) {
            fileTargetDir.mkdirs();
        }

        List<ProductPicEntity> picList = new ArrayList<>();

        for (MultipartFile img : pics) {
            String savedFileNm = FileUtils.makeRandomFileNm(img.getOriginalFilename());
            System.out.println("savedFileNm : " + savedFileNm); //파일명 만든다

            //객체 만든다
            File fileTarget = new File(String.format("%s/%s", targetDir, savedFileNm));

            try {
                img.transferTo(fileTarget); //이동시킨다
            } catch (IOException e) {
                e.printStackTrace();
                throw new Exception("이미지 저장 실패"); //예외처리 시켜준다
            }

            // DB item 값
            ProductPicEntity entity = new ProductPicEntity();
            entity.setIproduct(iproduct);
            entity.setPic(savedFileNm);
            picList.add(entity);
        }

        return Long.valueOf(mapper.insProductPic(picList));
    }

    List<ProductVo> selProduct() {
        return mapper.selProduct();
    }

    public ProductDetailResponse selByIdProduct(ProductSelDetailDto dto) {
        ProductVo data = mapper.selProductById(dto);
        List<String> pics = mapper.selProductPics(dto);

        return ProductDetailResponse.builder()
                .data(data)
                .pics(pics)
                .build();
    }


}
//        ProductPicEntity entity = new ProductPicEntity();
//
//        for (int i = 0; i < pics.size(); i++) {
//            String savedFileNm = FileUtils.makeRandomFileNm(pics.get(i).getOriginalFilename());
//
//            // DB에 보내주자
//            entity.setPic(savedFileNm);
//            entity.setIproduct(iproduct);
//            mapper.insProductPic(entity);
//
//            // 파일 보내주자
//            String targetDic = String.format("%s/product/%d/pics", fileDir, iproduct);
//            File fileTargetDir = new File(targetDic);
//
//            if (!fileTargetDir.exists()) {
//                fileTargetDir.mkdirs(); //파일 만들어주는 메소드 mkdirs
//            }
//
//            //이미지를 해당 폴더로 이동 시키기
//            File fileTarget = new File(targetDic + "/" + savedFileNm);
//
//            try {
//                    pics.get(i).transferTo(fileTarget);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return 0;
//            }
//        }
//        return 1;


