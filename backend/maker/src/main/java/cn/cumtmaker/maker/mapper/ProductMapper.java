package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.form.ProductFormObject;
import cn.cumtmaker.maker.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMapper {
    Product selectByProductId(Integer productId);

    List<Integer> getValueIdsByProductId(Integer productId);

    Integer insert(ProductFormObject productFormObject);

    Integer deleteByProductId(Integer productId);

    Integer updateByProductId(@Param("productId") Integer productId, @Param("price") BigDecimal price, @Param("stock") Integer stock, @Param("productName") String productName);

    Integer updateStock(@Param("productId") Integer productId, @Param("productStock") Integer productStock,@Param("sales") Integer sales);

    List<Product> selectAll();
}
