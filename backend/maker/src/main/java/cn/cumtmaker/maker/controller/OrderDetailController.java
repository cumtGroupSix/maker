package cn.cumtmaker.maker.controller;


import cn.cumtmaker.maker.model.OrderDetail;
import cn.cumtmaker.maker.service.impl.OrderDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@RequestMapping(value = "api/orderDetail", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value = "api/orderDetail", tags = "orderDetailApi", description = "订单接口")
public class OrderDetailController {
   @Autowired
   OrderDetailService orderDetailService;

    @PutMapping(value = "/insert")
    @ApiOperation(value = "添加订单信息", response = OrderDetail.class, responseContainer = "list")
    public ResponseEntity insertOrder(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok(orderDetailService.insertOrder(orderDetail));
    }
}
