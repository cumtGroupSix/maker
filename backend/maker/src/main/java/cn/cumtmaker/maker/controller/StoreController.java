package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.model.Store;
import cn.cumtmaker.maker.service.StoreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/store")
public class StoreController {
    @Autowired
    StoreService storeService;

    /**
     * 热门店铺列表
     * @return List<StoreVO> 热门店铺列表
     */
    @GetMapping("/hot")
    @ApiOperation(value = "获取热门店铺")
    public List<StoreVO> getHotStore(){
        return storeService.getHotStores();
    }

    /**
     *
     * @param storeId
     * @param storeName
     * @param storeIntroduce
     * @param imgUrl
     * @return
     */
    @PutMapping(value = "/updateStore")
    @ApiOperation(value = "更新店铺信息",response = Store.class,responseContainer = "list")
    public ResponseEntity updateStore(Integer storeId,String storeName,String storeIntroduce,String imgUrl){
        return ResponseEntity.ok(storeService.updateStore(storeId,storeName,storeIntroduce,imgUrl));
    }

    /**
     * 通过categoryId查找出所有拥有此类型商品的店铺
     * @param categoryId
     * @return List<StoreVO> 店铺列表
     */
    @GetMapping("/category")
    @ApiOperation(value = "通过categoryId查找出所有拥有此类型商品的店铺")
    public List<StoreVO> getStoresByCategoryId(@RequestParam Integer categoryId){
        return storeService.getStoresByCategoryId(categoryId);
    }

}
