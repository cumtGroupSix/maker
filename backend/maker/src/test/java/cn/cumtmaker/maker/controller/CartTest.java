package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.model.CartProduct;
import cn.cumtmaker.maker.model.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTest {
    @Autowired
    CartController cartController;

//    测试根据用户ID获取购物车信息
    @Test
    public void getCart(){
        System.out.println(cartController.getCartProduct(1).toString());
    }

//    测试根据购物车ID，商店ID，商品ID删除购物车商品
    @Test
    public void deleteCartProduct(){
        cartController.deleteCartProduct(1,1,1);
    }

//    测试更新购物车中的商品数量
    @Test
    public void updateQuantity(){
        CartProduct cartProduct = new CartProduct();
        cartProduct.setCartId(1);
        cartProduct.setProductId(1);
        cartProduct.setStoreId(1);
        cartProduct.setProductQuantity(2);
        System.out.println(cartController.updateQuantity(1,1,1,2).toString());
    }

//    测试向购物车中增加商品
    @Test
    public void insertGroup(){
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductQuantity(1);
        cartProduct.setProductId(1);
        cartProduct.setStoreId(1);
        cartProduct.setCartId(1);
        System.out.println(cartProduct.toString());
    }
}

