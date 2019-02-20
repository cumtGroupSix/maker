package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.model.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailTest {
    @Autowired
    OrderDetailController orderDetailController;

//    测试提交（增加）订单信息
    @Test
    public void insertOrder(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(1);
        orderDetail.setOrderStatus(0);
        orderDetail.setProductQuantity(2);
        orderDetail.setDetailId(1);
        orderDetail.setProductId(1);
        BigDecimal number = new BigDecimal(2);
        int value= hashCode();
        number = BigDecimal.valueOf((int)value);
        orderDetail.setProductPrice(number);
        System.out.println(orderDetail.toString());
    }

//    测试查询订单详情
    @Test
    public void getOrder(){
        System.out.println(orderDetailController.getOrder(1).toString());
    }
}