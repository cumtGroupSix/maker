package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.GoodsListVO;
import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.VO.ProductGroupDetailVO;
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

    /**
     * 创客为创客店增添商品
     * @param storeId
     * @param products
     * @return
     */
    @PostMapping("/maker/insert")
    @ApiOperation(value = "创客为创客店增添商品")
    public Integer MakerAddProductGroup(@RequestParam Integer storeId, @RequestParam ArrayList<Integer> products){
        return productGroupService.addProduct(storeId, products);
    }

    /**
     * 供应商增添商品接口
     * @param productGroupFormObject
     * @return
     */
    @PostMapping("/supplier/insert")
    @ApiOperation(value = "供应商增添商品")
    public Integer SupplierAddProductGroup(@RequestBody ProductGroupFormObject productGroupFormObject){
        return productGroupService.supplierAddProduct(productGroupFormObject);
    }

    /**
     * 通过groupId获取该group中所有产品的详情
     * @param groupId
     * @return
     */
    @GetMapping("/group/{groupId}")
    @ApiOperation(value = "通过groupId获取该group中所有产品的详情")
    public List<ProductDetailVO> getDetailByGroupId(@PathVariable Integer groupId){
        return productGroupService.getDetailByGroupId(groupId);
    }

    /**
     * 为/goodslist提供数据
     * @return GoodsListVO 商品组代表产品列表
     */
    @GetMapping("/goodslist/all")
    @ApiOperation(value = "为/goodslist提供数据")
    public List<GoodsListVO> getAll(){
        return productGroupService.getAll();
    }

    /**
     * 根据categoryId查找list
     * @param categoryId
     * @return GoodsListVO 商品组代表产品列表
     */
    @GetMapping("/goodslist/{categoryId}")
    @ApiOperation(value = "根据categoryId查找list")
    public List<GoodsListVO> getAll(@PathVariable Integer categoryId){
        return productGroupService.getListByCategoryId(categoryId);
    }

    /**
     * 根据categoryName查找list
     * @param categoryName
     * @return GoodsListVO 商品组代表产品列表
     */
    @GetMapping("/goodslist")
    @ApiOperation(value = "根据categoryName查找list")
    public List<GoodsListVO> getAllByCategoryName(@RequestParam String categoryName){
        return productGroupService.getListByCategoryName(categoryName);
    }

    /**
     * 通过group的productName查出group所有产品详情
     * @param productName
     * @return group所有产品详情
     */
    @GetMapping("/group/detail")
    @ApiOperation(value = "通过group的productName查出group所有产品详情")
    public List<ProductDetailVO> getDetailByProductName(@RequestParam String productName){
        return productGroupService.getDetailByProductName(productName);
    }

    /**
     * 供应商修改产品详情接口
     * @param productGroupDetailVO
     * @return
     */
    @PutMapping("/supplier/update")
    @ApiOperation(value = "供应商修改产品详情接口")
    public Integer supplierUpdate(@RequestBody ProductGroupDetailVO productGroupDetailVO){
        return productGroupService.supplierUpdate(productGroupDetailVO);
    }

    /**
     * 供应商删除商品接口
     * @param groupId
     * @return
     */
    @DeleteMapping("/supplier/delete")
    @ApiOperation(value = "供应商删除商品接口")
    public Integer supplierDelete(@RequestParam Integer groupId){
        return productGroupService.supplierDelete(groupId);
    }

    /**
     * 为供应商通过categoryId查找出所有group详情
     * @param categoryId
     * @return group详情列表
     */
    @GetMapping("/supplier/group/detail")
    @ApiOperation(value = "为供应商通过categoryId查找出所有group详情")
    public List<ProductGroupDetailVO> getGroupDetail(@RequestParam Integer categoryId){
        return productGroupService.getGroupDetailByCategoryId(categoryId);
    }

}
