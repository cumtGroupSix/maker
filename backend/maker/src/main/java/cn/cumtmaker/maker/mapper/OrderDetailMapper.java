package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.VO.OrderDetailProductVO;
import cn.cumtmaker.maker.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    int insertOrder(OrderDetail orderDetail);
    OrderDetail getOrder(Integer detailId);
    Integer deleteByProductId(Integer productId);
    List<OrderDetailProductVO> getProduct(Integer orderId);
}
