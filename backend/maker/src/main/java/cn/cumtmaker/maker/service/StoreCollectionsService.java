package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.StoreVO;

import java.util.List;

public interface StoreCollectionsService {
    int collectStore(int userId, int collectStoreId);
    int cancelCollectStore(int userId, int collectStoreId);
    List<StoreVO> getCollectStores(int userId);
}
