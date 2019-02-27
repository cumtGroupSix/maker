package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.GroupSpecificationKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupSpecificationMapper {
    int deleteByPrimaryKey(GroupSpecificationKey key);

    int insert(GroupSpecificationKey record);

    int insertSelective(GroupSpecificationKey record);

    Integer deleteByGroupId(Integer groupId);
}