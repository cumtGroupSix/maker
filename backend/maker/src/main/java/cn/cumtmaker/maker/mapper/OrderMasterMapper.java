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
    int updatePayStatus(@Param("userId") Integer userId, @Param("orderId") Integer orderId, @Param("payStatus") Integer payStatus);
    int insertOrder(OrderMaster orderMaster);
    List<OrderMaster> getByUserId(Integer userId);
    int getOrderId(@Param("userId") Integer userId, @Param("orderTime") String orderTime);

}