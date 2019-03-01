package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Store;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreMapper {
    Store selectById(Integer storeId);
    Store selectByCartId(Integer storeId);

    /**
     * 更新店铺信息
     */
    int updateStore(@Param("storeId") Integer storeId, @Param("storeName") String storeName, @Param("storeIntroduce")String storeIntroduce, @Param("imgUrl") String imgUrl);

    List<Store> getHotStores();
}
