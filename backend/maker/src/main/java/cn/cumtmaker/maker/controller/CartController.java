package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/cart",produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value="api/cart",tags="CartApi",description="购物车接口")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/get")
    @ApiOperation(value = "获取购物车",response= Cart.class)
    public Cart getCartProduct(Integer id){
        Cart cart = cartService.getCart(id);
        return cart;
    }
}
