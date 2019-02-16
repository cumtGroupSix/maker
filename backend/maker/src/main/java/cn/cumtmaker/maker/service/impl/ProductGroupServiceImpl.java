package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.mapper.ProductGroupMapper;
import cn.cumtmaker.maker.service.ProductGroupService;
import cn.cumtmaker.maker.util.ProductDetailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {

    @Autowired
    ProductGroupMapper productGroupMapper;

    @Override
    public Integer addProduct(Integer storeId, List<Integer> products) {
        int result = 0;
        //todo 未判断表中是否存在此商品
        for(Integer productId : products){
            Integer num = productGroupMapper.addProduct(storeId, productId);
            result += num;
        }
        return result;
    }

    @Override
    public List<ProductDetailVO> getDetailByGroupId(Integer groupId) {
        List<ProductDetailVO> productDetailVOS = new ArrayList<>();
        List<Integer> productIds = productGroupMapper.getAllProductIdByGroupId(groupId);
        for (Integer productId : productIds){
            productDetailVOS.add(ProductDetailUtil.getDetailByProductId(productId));
        }
        return productDetailVOS;
    }
}
