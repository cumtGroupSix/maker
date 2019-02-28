package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.service.ProductService;
import cn.cumtmaker.maker.service.impl.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CommentService commentService;

    @GetMapping("/{productId}")
    public ProductDetailVO getDetailByProductId(@PathVariable Integer productId){
        return productService.getDetailByProductId(productId);
    }

    @ResponseBody
    @GetMapping("/getProductComments/{productId}")
    @ApiOperation(value = "根据productId获取评论")
    public ResponseEntity getProductComments(@PathVariable("productId") Integer productId){
        return ResponseEntity.ok(commentService.getProductComments(productId));
    }

}
