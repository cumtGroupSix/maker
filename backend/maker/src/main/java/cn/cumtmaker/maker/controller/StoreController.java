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

    @GetMapping("/hot")
    public List<StoreVO> getHotStore(){
        return storeService.getHotStores();
    }

    @PutMapping(value = "/updateStore")
    @ApiOperation(value = "更新店铺信息",response = Store.class,responseContainer = "list")
    public ResponseEntity updateStore(Integer storeId,String storeName,String storeIntroduce,String imgUrl){
        return ResponseEntity.ok(storeService.updateStore(storeId,storeName,storeIntroduce,imgUrl));
    }
}
