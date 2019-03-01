package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.model.Cart;
import org.apache.ibatis.annotations.Param;

/**
 * CartProductService接口
 */
public interface CartProductService {
    int updateQuantity(Integer cartId,Integer storeId,Integer productId,Integer productQuantity);
    int deleteCartProduct(Integer cartId,Integer storeId,Integer productId);
    int insertGroup(Integer userId,Integer storeId,Integer collectGroupId);
}
