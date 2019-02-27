package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.ProductValueKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductValueMapper {
    int deleteByPrimaryKey(ProductValueKey key);

    int insert(ProductValueKey record);

    int insertSelective(ProductValueKey record);

    Integer deleteByProductId(Integer productId);
}