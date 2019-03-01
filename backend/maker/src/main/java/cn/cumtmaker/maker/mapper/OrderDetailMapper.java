package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.VO.OrderDetailProductVO;
import cn.cumtmaker.maker.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    /**
     * 添加订单
     * @param orderDetail
     * @return 0/1
     */
    int insertOrder(OrderDetail orderDetail);

    /**
     *根据订单ID获取订单详情
     * @param detailId
     * @return 0/1
     */
    OrderDetail getOrder(Integer detailId);

    /**
     * 根据商品ID删除商品
     * @param productId
     * @return 0/1
     */
    Integer deleteByProductId(Integer productId);

    List<OrderDetailProductVO> getProduct(Integer orderId);

    /**
     * 根据订单ID获取订单详情列表
     * @param orderId
     * @return 0/1
     */
    List<OrderDetail> getByOrderId(Integer orderId);
}
