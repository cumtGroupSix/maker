package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.CartProductMapper;
import cn.cumtmaker.maker.mapper.GroupCollectionsMapper;
import cn.cumtmaker.maker.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductServiceImpl implements CartProductService {
    @Autowired
    CartProductMapper cartProductMapper;

    @Autowired
    GroupCollectionsMapper groupCollectionsMapper;

    //更新购物车数量
    @Override
    public int updateQuantity(Integer cartId,Integer storeId,Integer productId,Integer productQuantity) {
    return cartProductMapper.updateQuantity(cartId,storeId,productId,productQuantity);
    }
    //删除购物车中商品
    @Override
    public int deleteCartProduct(Integer cartId,Integer storeId,Integer productId){
        return cartProductMapper.deleteCartProduct(cartId,storeId,productId);
    }
    //购物车中收藏商品
    @Override
    public int insertGroup(Integer userId,Integer storeId,Integer collectGroupId){
        return groupCollectionsMapper.insertGroup(userId,storeId,collectGroupId);
    }
}
