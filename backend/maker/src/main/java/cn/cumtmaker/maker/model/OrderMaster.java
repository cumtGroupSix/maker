package cn.cumtmaker.maker.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMaster {
    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 支付状态
     */
    private Byte payStatus;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取支付状态
     *
     * @return pay_status - 支付状态
     */
    public Byte getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态
     *
     * @param payStatus 支付状态
     */
    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取订单总金额
     *
     * @return order_amount - 订单总金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单总金额
     *
     * @param orderAmount 订单总金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}