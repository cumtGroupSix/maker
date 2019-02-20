package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.model.Store;

import java.util.List;

public interface StoreService {
    List<StoreVO> getHotStores();
}
