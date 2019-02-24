package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.StoreProductKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreProductMapper {
    int deleteByPrimaryKey(StoreProductKey key);

    int insert(StoreProductKey record);

    int insertSelective(StoreProductKey record);

    List<Integer> getStoreIdsByGroupId(Integer groupId);
}