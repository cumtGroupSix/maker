package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.ProductVO;
import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.mapper.ProductMapper;
import cn.cumtmaker.maker.mapper.StoreMapper;
import cn.cumtmaker.maker.model.Product;
import cn.cumtmaker.maker.model.Store;
import cn.cumtmaker.maker.service.StoreService;
import cn.cumtmaker.maker.util.StoreVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreMapper storeMapper;

    @Override
    public List<StoreVO> getHotStores() {
        List<Store> stores= storeMapper.getHotStores();
        List<StoreVO> storeVOS=new ArrayList<>();
        for (Store store : stores){
            storeVOS.add(StoreVOUtil.create(store));
        }
        return storeVOS;
    }

    private static StoreVO convertStoreToStoreVO(Store store){
        if (store == null){
            return null;
        }
        StoreVO storeVO=new StoreVO();
        BeanUtils.copyProperties(store,storeVO);
        return storeVO;
    }

    private static ProductVO convertProductToProductVO(Product product){
        if (product == null){
            return null;
        }
        ProductVO productVO = new ProductVO();
        BeanUtils.copyProperties(product,productVO);
        return productVO;
    }
}
