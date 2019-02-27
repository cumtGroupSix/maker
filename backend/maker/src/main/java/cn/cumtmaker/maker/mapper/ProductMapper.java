package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.form.ProductFormObject;
import cn.cumtmaker.maker.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMapper {
    Product selectByProductId(Integer productId);

    List<Integer> getValueIdsByProductId(Integer productId);

    Integer insert(ProductFormObject productFormObject);

    Integer deleteByProductId(Integer productId);

    Integer updatePriceByProductId(@Param("productId") Integer productId,@Param("price") BigDecimal price);
}
