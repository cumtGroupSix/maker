package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.ProductGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductGroupMapper {
    List<ProductGroup> selectProductGroupsByStoreId(Integer storeId);
}
