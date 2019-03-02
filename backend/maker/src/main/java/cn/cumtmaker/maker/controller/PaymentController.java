package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.service.PaymentService;
import cn.cumtmaker.maker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/payment",produces = {APPLICATION_JSON_UTF8_VALUE})
@Controller
@Api(value="api/payment",tags="PaymentApi",description="支付接口")
/**
 * 支付Controller
 */
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    UserService userService;

    /**
     * 更新支付状态
     * @param request
     * @param orderId
     * @param payStatus
     * @return 0/1
     */
    @ResponseBody
    @PostMapping("/updatePayStatus")
    @ApiOperation(value = "更新支付状态")
    public ResponseEntity updatePayStatus(HttpServletRequest request, Integer orderId, Integer payStatus){
       return  ResponseEntity.ok(paymentService.updatePayStatus(request,orderId,payStatus));
    }
}
