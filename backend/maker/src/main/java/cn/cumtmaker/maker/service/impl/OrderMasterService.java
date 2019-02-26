package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.OrderMasterMapper;
import cn.cumtmaker.maker.model.OrderDetail;
import cn.cumtmaker.maker.model.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMasterService {
    @Autowired
    OrderMasterMapper orderMasterMapper;

    public int insertOrder (OrderMaster orderMaster) {
        return orderMasterMapper.insertOrder(orderMaster);
    }


}
