package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.service.CartProductService;
import cn.cumtmaker.maker.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/cart",produces = {APPLICATION_JSON_UTF8_VALUE})
@Controller
@Api(value="api/cart",tags="CartApi",description="购物车接口")
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    CartProductService cartProductService;

    @ResponseBody
    @GetMapping("/get")
    @ApiOperation(value = "根据UserId获取购物车",response= Cart.class)
    public Cart getCartProduct(Integer id){
        Cart cart = cartService.getCart(id);
        return cart;
    }

    @ResponseBody
    @PostMapping("/updateQuantity")
    @ApiOperation(value = "更新购物车商品数量")
    public ResponseEntity updateQuantity(Integer cartId, Integer storeId, Integer productId, Integer productQuantity){
       return  ResponseEntity.ok(cartProductService.updateQuantity(cartId,storeId,productId,productQuantity));
    }

    @ResponseBody
    @DeleteMapping("/deleteCartProduct")
    @ApiOperation(value = "删除购物车商品")
    public ResponseEntity deleteCartProduct(Integer cartId, Integer storeId, Integer productId){
        return  ResponseEntity.ok(cartProductService.deleteCartProduct(cartId,storeId,productId));
    }

    @ResponseBody
    @PutMapping("/collectCartProduct")
    @ApiOperation(value = "收藏购物车商品")
    public ResponseEntity collectCartProduct(Integer userId, Integer storeId, Integer groupId){
        return  ResponseEntity.ok(cartProductService.insertGroup(userId,storeId,groupId));
    }
}
