package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.model.Cart;


public interface PaymentService {
    int updatePayStatus(Integer userId,Integer orderId, Integer payStatus);

}
