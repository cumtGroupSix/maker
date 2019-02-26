package cn.cumtmaker.maker.mapper;


import cn.cumtmaker.maker.model.GroupCollections;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupCollectionsMapper{
    int insertGroup(@Param("userId") Integer userId, @Param("storeId") Integer storeId, @Param("collectGroupId") Integer collectGroupId);
    List<GroupCollections> getGroupCollectionsByUserId(@Param("userId") Integer userId);
    int deleteGroupCollections(@Param("userId") Integer userId, @Param("storeId") Integer storeId, @Param("collectGroupId") Integer collectGroupId);
}