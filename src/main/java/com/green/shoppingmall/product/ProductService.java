package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import com.green.shoppingmall.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


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

        System.out.println("result : " + result);
        System.out.println("pk : " + entity.getIproduct());
        //

        return 0;
    }

}
