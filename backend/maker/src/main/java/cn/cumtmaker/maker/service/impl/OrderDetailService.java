package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.OrderDetailProductVO;
import cn.cumtmaker.maker.mapper.OrderDetailMapper;
import cn.cumtmaker.maker.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;

    public int insertOrder (OrderDetail orderDetail) {
        return orderDetailMapper.insertOrder(orderDetail);
    }

    public OrderDetail getOrder(Integer detailId) {
        OrderDetail orderDetail = orderDetailMapper.getOrder(detailId);
        return orderDetailMapper.getOrder(detailId);
    }

    //根据订单id获取购买商品数量
    public List<OrderDetailProductVO> getProduct(Integer orderId) {
        return orderDetailMapper.getProduct(orderId);
    }
}
