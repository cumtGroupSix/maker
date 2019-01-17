package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.OrderDetailMapper;
import cn.cumtmaker.maker.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;

    public int insertOrder (OrderDetail orderDetail) {
        return orderDetailMapper.insertOrder(orderDetail);
    }
}
