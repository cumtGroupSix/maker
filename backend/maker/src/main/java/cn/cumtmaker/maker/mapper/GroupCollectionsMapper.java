package cn.cumtmaker.maker.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GroupCollectionsMapper{
    int insertGroup(@Param("userId") Integer userId, @Param("storeId") Integer storeId, @Param("collectGroupId") Integer collectGroupId);
}