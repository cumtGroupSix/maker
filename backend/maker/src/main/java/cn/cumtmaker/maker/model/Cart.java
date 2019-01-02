package cn.cumtmaker.maker.model;

import org.apache.ibatis.type.Alias;

import java.util.List;

public class Cart {
    private Integer cartId;

    private Integer userId;


    public List<CartProduct> cartproduct;




    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}