package cn.cumtmaker.maker.mapper;


import cn.cumtmaker.maker.model.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMasterMapper {
    int updatePayStatus(@Param("userId") Integer userId, @Param("orderId") Integer orderId, @Param("payStatus") Integer payStatus);
    int insertOrder(OrderMaster orderMaster);

}