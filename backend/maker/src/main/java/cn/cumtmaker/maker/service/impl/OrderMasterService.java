package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.OrderMasterMapper;
import cn.cumtmaker.maker.model.OrderDetail;
import cn.cumtmaker.maker.model.OrderMaster;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderMasterService {
    @Autowired
    OrderMasterMapper orderMasterMapper;

    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     * 添加订单
     * @param orderMaster
     * @return
     */
    public int insertOrder (OrderMaster orderMaster) {
        int code=orderMasterMapper.insertOrder(orderMaster);
        if(code==1){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp=new Timestamp(orderMaster.getOrderTime().getTime()-8*3600*1000);
            Date date=new Date(timestamp.getTime());
            String orderTime=simpleDateFormat.format(date);
            logger.info("UserID为"+orderMaster.getUserId()+"的用户添加了新的未支付订单"+"【"+orderTime+"】");
            return getOrderId(orderMaster.getUserId(),orderTime);
        }
        return code;
    }

    public int getOrderId(Integer userId, String orderTime){
        return orderMasterMapper.getOrderId(userId,orderTime);
    }

    /**
     * 根据用户ID获取订单管理列表
     * @param userId
     * @return 0/1
     */
    public List<OrderMaster> getByUserId(Integer userId){
        return orderMasterMapper.getByUserId(userId);
    }

}
