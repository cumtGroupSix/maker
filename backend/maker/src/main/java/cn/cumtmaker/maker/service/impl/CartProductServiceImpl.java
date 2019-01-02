package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.CartProductMapper;
import cn.cumtmaker.maker.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductServiceImpl implements CartProductService {
    @Autowired
    CartProductMapper cartProductMapper;

    @Override
    public int updateQuantity(Integer cartId,Integer storeId,Integer productId,Integer productQuantity) {
    return cartProductMapper.updateQuantity(cartId,storeId,productId,productQuantity);
    }
    @Override
    public int deleteCartProduct(Integer cartId,Integer storeId,Integer productId){
        return cartProductMapper.deleteCartProduct(cartId,storeId,productId);
    }
}
