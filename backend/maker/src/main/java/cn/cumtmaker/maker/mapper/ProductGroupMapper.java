package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.ProductGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductGroupMapper {
    List<ProductGroup> selectProductGroupsByStoreId(Integer storeId);

    Integer addProduct(@Param("storeId") Integer storeId, @Param("productId") Integer productId);

    List<Integer> getAllProductIdByGroupId(Integer groupId);
}
