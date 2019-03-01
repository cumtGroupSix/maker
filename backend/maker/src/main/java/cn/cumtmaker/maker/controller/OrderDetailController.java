package cn.cumtmaker.maker.controller;


import cn.cumtmaker.maker.model.OrderDetail;
import cn.cumtmaker.maker.service.impl.OrderDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@RequestMapping(value = "api/orderDetail", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value = "api/orderDetail", tags = "orderDetailApi", description = "订单详情接口")
public class OrderDetailController {
   @Autowired
   OrderDetailService orderDetailService;

    /**
     *添加订单信息
     * @param orderDetail
     * @return 0/1
     */
    @PostMapping(value = "/insertOrderDetail",consumes="application/json")
    @ApiOperation(value = "添加订单信息")
    public ResponseEntity insertOrder(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok(orderDetailService.insertOrder(orderDetail));
    }

    /**
     *根据订单详情ID获取订单详情
     * @param detailId
     * @return 0/1
     */
    @GetMapping("/getOrderDetail")
    @ApiOperation(value = "根据detailId获取订单信息")
    public ResponseEntity getOrder(Integer detailId){
        return  ResponseEntity.ok(orderDetailService.getOrder(detailId));
    }

    /**
     *根据订单ID获取订单详情
     * @param orderId
     * @return 0/1
     */
    @GetMapping(path="/getByOrderId/{orderId}")
    @ApiOperation(value = "根据orderId获取订单详情",response = OrderDetail.class,responseContainer = "list")
    public ResponseEntity getByOrderId(@ApiParam(value = "detailId",required = true)@PathVariable Integer orderId){
        return ResponseEntity.ok(orderDetailService.getByOrderId(orderId));
    }
}
