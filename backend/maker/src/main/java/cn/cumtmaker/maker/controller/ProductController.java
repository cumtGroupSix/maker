package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{productId}")
    public ProductDetailVO getDetailByProductId(@PathVariable Integer productId){
        return productService.getDetailByProductId(productId);
    }

}
