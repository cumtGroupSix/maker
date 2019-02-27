package cn.cumtmaker.maker.service;

import javax.servlet.http.HttpServletRequest;


public interface PaymentService {
    int updatePayStatus(HttpServletRequest httpServletRequest, Integer orderId, Integer payStatus);

}
