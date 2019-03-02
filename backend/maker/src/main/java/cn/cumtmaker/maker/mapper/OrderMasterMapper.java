package cn.cumtmaker.maker.mapper;


import cn.cumtmaker.maker.model.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMasterMapper {
    /**
     * 更新支付状态
     * @param userId
     * @param orderId
     * @param payStatus
     * @return 0/1
     */
    int updatePayStatus(@Param("userId") Integer userId, @Param("orderId") Integer orderId, @Param("payStatus") Integer payStatus);

    /**
     * 添加订单管理记录
     * @param orderMaster
     * @return 0/1
     */
    int insertOrder(OrderMaster orderMaster);

    /**
     * 根据用户ID获取订单管理列表
     * @param userId
     * @return 0/1
     */
    List<OrderMaster> getByUserId(Integer userId);

    int getOrderId(@Param("userId") Integer userId, @Param("orderTime") String orderTime);

}