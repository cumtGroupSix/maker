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

    /**
     * 添加订单
     * @param orderDetail
     * @return 0/1
     */
    public int insertOrder (OrderDetail orderDetail) {
        return orderDetailMapper.insertOrder(orderDetail);
    }

    /**
     * 根据订单详情ID获取订单详情
     * @param detailId
     * @return 0/1
     */
    public OrderDetail getOrder(Integer detailId) {
        OrderDetail orderDetail = orderDetailMapper.getOrder(detailId);
        return orderDetailMapper.getOrder(detailId);
    }

    /**
     * 根据订单id获取购买商品数量
     * @param orderId
     * @return 0/1
     */
    public List<OrderDetailProductVO> getProduct(Integer orderId) {
        return orderDetailMapper.getProduct(orderId);
    }

    /**
     * 根据订单ID获取订单详情列表
     * @param orderId
     * @return
     */
    public List<OrderDetail> getByOrderId(Integer orderId){
        return orderDetailMapper.getByOrderId(orderId);
    }
}
