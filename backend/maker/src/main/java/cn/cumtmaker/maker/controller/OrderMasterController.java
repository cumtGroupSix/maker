package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.model.OrderMaster;
import cn.cumtmaker.maker.service.UserService;
import cn.cumtmaker.maker.service.impl.OrderMasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value = "api/orderMaster", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value = "api/orderMaster", tags = "orderMasterApi", description = "订单管理接口")
public class OrderMasterController {
    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/insertOrderMaster")
    @ApiOperation(value = "添加订单信息")
    public ResponseEntity insertOrder(@RequestBody OrderMaster orderMaster) {
        return ResponseEntity.ok(orderMasterService.insertOrder(orderMaster));
    }

    @GetMapping("/getByUserId")
    @ApiOperation(value = "根据userId获取订单信息")
    public ResponseEntity getByUserId(HttpServletRequest request){
        int userId=userService.getUserByRequest(request).getUserId();
        return  ResponseEntity.ok(orderMasterService.getByUserId(userId));
    }
}
