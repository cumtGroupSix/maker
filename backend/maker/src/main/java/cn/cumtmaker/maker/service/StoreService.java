package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.model.Store;

import java.util.List;

public interface StoreService {
    List<StoreVO> getHotStores();

    Integer updateStore(Integer storeId,String storeName,String storeIntroduce,String imgUrl);

    List<StoreVO> getStoresByCategoryId(Integer categoryId);
}
