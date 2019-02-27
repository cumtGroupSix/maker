package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.CartMapper;
import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    //根据cartId获取cart
    @Override
    public Cart getCart(Integer id) {
        Cart cart= cartMapper.selectCartByUserId(id);
        return cart;
    }
}
