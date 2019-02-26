package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.GroupCollectionVO;

import java.util.List;

public interface GroupCollectionsService {
    int collectGroup(Integer userId, Integer storeId, Integer collectGroupId);
    int cancelCollectGroup(Integer userId, Integer storeId, Integer collectGroupId);
    List<GroupCollectionVO> getCollectStores(Integer userId);
}
