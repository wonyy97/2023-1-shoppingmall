package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import com.green.shoppingmall.product.model.SingSangSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }
                                                                                            //@RequestBody JSON 형식으로 받을 때
    @PostMapping( consumes={ MediaType.MULTIPART_FORM_DATA_VALUE
                            , MediaType.APPLICATION_JSON_VALUE })                            //@RequestParam 쿼리스트링으로 받을 때
    public int insProduct(@RequestPart MultipartFile img, @RequestPart ProductInsDto dto) { //@RequestPart 파일 업로드 할 때 사용

        return service.insProduct(img, dto);
    }

    //연습했음
    @PostMapping(value ="/file", consumes={ MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public int song(@RequestPart MultipartFile file, @RequestPart SingSangSong data) {
        System.out.println(data);
        System.out.println(file.getOriginalFilename());
        return 0;
    }


}
