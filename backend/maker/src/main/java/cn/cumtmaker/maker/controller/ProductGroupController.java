package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.service.ProductGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductGroupController {
    @Autowired
    ProductGroupService productGroupService;
    @PostMapping("/insert")
    @ApiOperation(value = "创客为创客店增添商品")
    public Integer AddProductGroup(@RequestParam Integer storeId, @RequestParam ArrayList<Integer> products){
        return productGroupService.addProduct(storeId, products);
    }
}
