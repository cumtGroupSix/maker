package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.CartProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartProductMapper {
    CartProduct getCartByCartId(Integer cartId);
}