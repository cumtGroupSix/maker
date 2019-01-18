package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.CartMapper;
import cn.cumtmaker.maker.mapper.OrderMasterMapper;
import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.service.CartService;
import cn.cumtmaker.maker.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    OrderMasterMapper orderMasterMapper;

    @Override
    public int updatePayStatus(Integer userId,Integer orderId,Integer payStatus)
    {
        return orderMasterMapper.updatePayStatus(userId,orderId,payStatus);
    }
}
