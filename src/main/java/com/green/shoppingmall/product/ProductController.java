package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    //@RequestBody JSON 형식으로 받을 때
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE
            , MediaType.APPLICATION_JSON_VALUE})                            //@RequestParam 쿼리스트링으로 받을 때
    public int insProduct(@RequestPart MultipartFile img, @RequestPart ProductInsDto dto) { //@RequestPart 파일 업로드 할 때 사용

        return service.insProduct(img, dto);
    }


    @PostMapping(value = "/{iproduct}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Long insProductPics(@PathVariable Long iproduct, @RequestPart List<MultipartFile> pics) throws Exception {
        return service.insProductPics(iproduct, pics);
    }

    @GetMapping
    public List<ProductVo> getProduct() {
        return service.selProduct();
    }

    @GetMapping("/{iproduct}")
    public ProductDetailResponse selByIdProduct(@PathVariable Long iproduct) {
        ProductSelDetailDto dto = new ProductSelDetailDto(1L);
        dto.setIproduct(iproduct);
        return service.selByIdProduct(dto);
    }


    //연습했음
    @PostMapping(value = "/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public int song(@RequestPart MultipartFile file, @RequestPart SingSangSong data) {
        System.out.println(data);
        System.out.println(file.getOriginalFilename());
        return 0;
    }


}
