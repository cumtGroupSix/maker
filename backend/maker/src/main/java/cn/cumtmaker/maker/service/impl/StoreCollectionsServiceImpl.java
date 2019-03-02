package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.mapper.StoreCollectionsMapper;
import cn.cumtmaker.maker.model.Store;
import cn.cumtmaker.maker.service.StoreCollectionsService;
import cn.cumtmaker.maker.util.StoreVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreCollectionsServiceImpl implements StoreCollectionsService {
    private static final Logger logger = LoggerFactory.getLogger(StoreCollectionsService.class);

    @Autowired
    private StoreCollectionsMapper storeCollectionsMapper;

    /**
     * 收藏店铺
     * @param userId
     * @param collectStoreId
     * @return
     */
    @Override
    public int collectStore(int userId, int collectStoreId) {
        int result = storeCollectionsMapper.collectStore(userId, collectStoreId);
        if (result != 0)
            logger.info("Id为" + userId + "的用户收藏了Id为" + collectStoreId + "的Store");
        else
            logger.info("Id为" + userId + "的用户试图收藏Id为" + collectStoreId + "的Store失败");
        return result;
    }

    /**
     * 取消收藏店铺
     * @param userId
     * @param collectStoreId
     * @return
     */
    @Override
    public int cancelCollectStore(int userId, int collectStoreId) {
        int result = storeCollectionsMapper.cancelCollectStore(userId, collectStoreId);
        if (result != 0)
            logger.info("Id为" + userId + "的用户取消收藏了Id为" + collectStoreId + "的Store");
        else
            logger.info("Id为" + userId + "的用户试图取消收藏Id为" + collectStoreId + "的Store失败");
        return result;
    }

    /**
     * 获取收藏的店铺
     * @param userId
     * @return
     */
    @Override
    public List<StoreVO> getCollectStores(int userId) {
        List<Store> stores= storeCollectionsMapper.getCollectStores(userId);
        List<StoreVO> storeVOS = new ArrayList<>();
        for (Store store : stores){
            storeVOS.add(StoreVOUtil.create(store));
        }
        logger.info("Id为" + userId + "的用户查询了自己收藏的店铺");
        return storeVOS;
    }
}
