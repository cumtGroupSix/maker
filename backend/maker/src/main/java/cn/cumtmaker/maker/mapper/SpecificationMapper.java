package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Specification;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpecificationMapper {
    int deleteByPrimaryKey(Integer specificationId);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer specificationId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}