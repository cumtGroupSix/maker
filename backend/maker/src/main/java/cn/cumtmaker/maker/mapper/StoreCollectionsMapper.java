package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StoreCollectionsMapper {
    int collectStore(@Param("userId") int userId, @Param("collectStoreId") int collectStoreId);
    int cancelCollectStore(@Param("userId") int userId, @Param("collectStoreId") int collectStoreId);
    List<Store> getCollectStores(int userId);
}
