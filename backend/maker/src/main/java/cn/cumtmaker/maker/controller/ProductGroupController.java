package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.GoodsListVO;
import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.form.ProductGroupFormObject;
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

    @PostMapping("/maker/insert")
    @ApiOperation(value = "创客为创客店增添商品")
    public Integer MakerAddProductGroup(@RequestParam Integer storeId, @RequestParam ArrayList<Integer> products){
        return productGroupService.addProduct(storeId, products);
    }

    @PostMapping("/supplier/insert")
    @ApiOperation(value = "供应商增添商品")
    public Integer SupplierAddProductGroup(@RequestBody ProductGroupFormObject productGroupFormObject){
        return productGroupService.supplierAddProduct(productGroupFormObject);
    }

    @GetMapping("/group/{groupId}")
    @ApiOperation(value = "通过groupId获取该group中所有产品的详情")
    public List<ProductDetailVO> getDetailByGroupId(@PathVariable Integer groupId){
        return productGroupService.getDetailByGroupId(groupId);
    }

    /**
     * 为/goodslist提供数据
     */
    @GetMapping("/goodslist/all")
    @ApiOperation(value = "为/goodslist提供数据")
    public List<GoodsListVO> getAll(){
        return productGroupService.getAll();
    }

    @GetMapping("/goodslist/{categoryId}")
    @ApiOperation(value = "根据categoryId查找list")
    public List<GoodsListVO> getAll(@PathVariable Integer categoryId){
        return productGroupService.getListByCategoryId(categoryId);
    }

//    @GetMapping("/all")
//    @ApiOperation(value = "返回所有类目及groups")
//    public List<>
}
