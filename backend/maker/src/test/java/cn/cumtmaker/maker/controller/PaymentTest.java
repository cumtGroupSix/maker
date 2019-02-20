package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.model.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTest {
    @Autowired
   PaymentController paymentController;

//    测试更新支付状态
    @Test
    public void updatePayStatus(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(1);
        orderMaster.setUserId(1);
        Byte a = 1;
        orderMaster.setPayStatus(a);
        System.out.println(paymentController.updatePayStatus(1,1,1).toString());
    }
}