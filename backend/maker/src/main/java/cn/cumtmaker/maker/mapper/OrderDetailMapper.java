package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
    int insertOrder(OrderDetail orderDetail);
    OrderDetail getOrder(Integer detailId);
}
