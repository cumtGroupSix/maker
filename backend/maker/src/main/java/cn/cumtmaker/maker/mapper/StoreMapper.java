package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    Store selectById(Integer storeId);

    List<Store> getHotStores();
}
