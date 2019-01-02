package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.CartProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartProductMapper {
    CartProduct getCartByCartId(Integer cartId);
    int updateQuantity(@Param("cartId") Integer cartId,@Param("storeId") Integer storeId,@Param("productId") Integer productId,@Param("productQuantity") Integer productQuantity);
    int deleteCartProduct(@Param("cartId") Integer cartId,@Param("storeId") Integer storeId,@Param("productId") Integer productId);
}