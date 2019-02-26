package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.GroupEvaluationVO;
import cn.cumtmaker.maker.VO.ProductGroupVO;
import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.mapper.GroupEvaluationMapper;
import cn.cumtmaker.maker.mapper.StoreMapper;
import cn.cumtmaker.maker.model.GroupEvaluation;
import cn.cumtmaker.maker.model.Store;
import cn.cumtmaker.maker.service.GroupEvaluationService;
import cn.cumtmaker.maker.util.StoreVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupEvaluationServiceImpl implements GroupEvaluationService {
    private static final Logger logger = LoggerFactory.getLogger(GroupEvaluation.class);

    @Autowired
    private GroupEvaluationMapper groupEvaluationMapper;
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public int addEvaluation(GroupEvaluation groupEvaluation) {
        return groupEvaluationMapper.addEvaluation(groupEvaluation);
    }

    @Override
    public int deleteEvaluation(GroupEvaluation groupEvaluation) {
        return groupEvaluationMapper.deleteEvaluation(groupEvaluation);
    }

    @Override
    public List<GroupEvaluationVO> getEvaluationsOfUser(int userId) {
        List<GroupEvaluation> groupEvaluations = groupEvaluationMapper.getEvaluationsOfUser(userId);
        List<GroupEvaluationVO> groupEvaluationVOS = new ArrayList<>();
        for (GroupEvaluation groupEvaluation : groupEvaluations) {
            //查询到Store
            Store store = storeMapper.selectById(groupEvaluation.getStoreId());
            //构造StoreVO
            StoreVO storeVO = StoreVOUtil.create(store);
            //查找是第几个商品被评价
            List<ProductGroupVO> productGroupVOS = storeVO.getProductGroupVOS();
            Integer evaluatedGroupIndex = null;
            for (int i = 0; i < productGroupVOS.size(); i++) {
                if (productGroupVOS.get(i).getGroupId().equals(groupEvaluation.getGroupId()))
                    evaluatedGroupIndex = i;
            }
            if (evaluatedGroupIndex == null)
                throw new IllegalStateException("个人评价商品store_id " + groupEvaluation.getStoreId() + "和group_id " + groupEvaluation.getGroupId() + "不对应");

            groupEvaluationVOS.add(new GroupEvaluationVO(storeVO, evaluatedGroupIndex, groupEvaluation.getValueDisabled()));
        }

        return groupEvaluationVOS;
    }
}
