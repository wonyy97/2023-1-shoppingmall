package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import com.green.shoppingmall.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Service
public class ProductService {

    private final ProductMapper mapper;

    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public ProductService(ProductMapper mapper) {
        this.mapper = mapper;
    }

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

}
