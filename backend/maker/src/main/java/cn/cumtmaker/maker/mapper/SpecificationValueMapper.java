package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.SpecificationValue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpecificationValueMapper {
    int deleteByPrimaryKey(Integer valueId);

    int insert(SpecificationValue record);

    int insertSelective(SpecificationValue record);

    SpecificationValue selectByPrimaryKey(Integer valueId);

    int updateByPrimaryKeySelective(SpecificationValue record);

    int updateByPrimaryKey(SpecificationValue record);
}