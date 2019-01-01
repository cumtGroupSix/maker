package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.model.Cart;
import org.apache.ibatis.annotations.Param;


public interface CartProductService {
    int updateQuantity(Integer cartId,Integer storeId,Integer productId,Integer productQuantity);
    int deleteCartProduct(Integer cartId,Integer storeId,Integer productId);
}
