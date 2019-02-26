package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.GroupCollectionVO;
import cn.cumtmaker.maker.VO.ProductGroupVO;
import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.mapper.GroupCollectionsMapper;
import cn.cumtmaker.maker.mapper.StoreMapper;
import cn.cumtmaker.maker.model.GroupCollections;
import cn.cumtmaker.maker.model.Store;
import cn.cumtmaker.maker.service.GroupCollectionsService;
import cn.cumtmaker.maker.util.StoreVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupCollectionsServiceImpl implements GroupCollectionsService {
    private static final Logger logger = LoggerFactory.getLogger(GroupCollectionsService.class);

    @Autowired
    private GroupCollectionsMapper groupCollectionsMapper;
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<GroupCollectionVO> getCollectStores(Integer userId) {
        List<GroupCollectionVO> groupCollectionVOS = new ArrayList<>();
        List<GroupCollections> groupCollections = groupCollectionsMapper.getGroupCollectionsByUserId(userId);
        for (GroupCollections groupCollections1 : groupCollections) {
            //查询到Store
            Store store = storeMapper.selectById(groupCollections1.getStoreId());
            //构造StoreV0
            StoreVO storeVO = StoreVOUtil.create(store);
            //查找是第几个商品被收藏
            List<ProductGroupVO> productGroupVOS = storeVO.getProductGroupVOS();
            Integer collectedGroupIndex = null;
            for (int i = 0; i < productGroupVOS.size(); i++) {
                if (productGroupVOS.get(i).getGroupId().equals(groupCollections1.getCollectGroupId()))
                    collectedGroupIndex = i;
            }
            if (collectedGroupIndex == null)
                throw new IllegalStateException("个人收藏商品store_id " + groupCollections1.getStoreId() + "和group_id " + groupCollections1.getCollectGroupId() + "不对应");

            groupCollectionVOS.add(new GroupCollectionVO(storeVO, collectedGroupIndex));
        }

        logger.info("Id为" + userId + "的用户查询了自己收藏的商品");
        return groupCollectionVOS;
    }

    @Override
    public int collectGroup(Integer userId, Integer storeId, Integer collectGroupId) {
        int result = groupCollectionsMapper.insertGroup(userId, storeId, collectGroupId);
        if (result != 0)
            logger.info("Id为" + userId + "的用户收藏了Id为" + storeId + "的Store的Id为" + collectGroupId + "的商品");
        else
            logger.info("Id为" + userId + "的用户试图收藏Id为" + storeId + "的Store的Id为" + collectGroupId + "的商品失败");
        return result;
    }

    @Override
    public int cancelCollectGroup(Integer userId, Integer storeId, Integer collectGroupId) {
        int result = groupCollectionsMapper.deleteGroupCollections(userId, storeId, collectGroupId);
        if (result != 0)
            logger.info("Id为" + userId + "的用户取消收藏Id为" + storeId + "的Store的Id为" + collectGroupId + "的商品");
        else
            logger.info("Id为" + userId + "的用户试图取消收藏Id为" + storeId + "的Store的Id为" + collectGroupId + "的商品失败");
        return result;
    }
}
