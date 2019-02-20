package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.form.ProductGroupFormObject;
import cn.cumtmaker.maker.model.ProductGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductGroupMapper {
    List<ProductGroup> selectProductGroupsByStoreId(Integer storeId);
<<<<<<< HEAD

    Integer addProduct(@Param("storeId") Integer storeId, @Param("productId") Integer productId);

    List<Integer> getAllProductIdByGroupId(Integer groupId);

    List<ProductGroup> getAll();

    List<ProductGroup> getGroupsByCategoryId(Integer categoryId);

    Integer insert(ProductGroupFormObject productGroupFormObject);

    void updateRepresentativeProductId(@Param("groupId")Integer groupId,@Param("representativeProductId") Integer representativeProductId);

    Integer selectProductGroupsNumByStoreId(Integer storeId);
=======
>>>>>>> d32cc79a215a021487d2338465b01f0131539145
}
