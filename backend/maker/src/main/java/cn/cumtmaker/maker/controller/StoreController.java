package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.model.Store;
import cn.cumtmaker.maker.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    @Autowired
    StoreService storeService;
    @GetMapping("/hot")
    public List<StoreVO> getHotStore(){
        return storeService.getHotStores();
    }
}
