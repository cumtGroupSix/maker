package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.service.CartProductService;
import cn.cumtmaker.maker.service.CartService;
import cn.cumtmaker.maker.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/payment",produces = {APPLICATION_JSON_UTF8_VALUE})
@Controller
@Api(value="api/payment",tags="PaymentApi",description="支付接口")
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    @ResponseBody
    @PostMapping("/updatePayStatus")
    @ApiOperation(value = "更新支付状态")
    public ResponseEntity updatePayStatus(Integer userId,Integer orderId,Integer payStatus){
       return  ResponseEntity.ok(paymentService.updatePayStatus(userId,orderId,payStatus));
    }
}