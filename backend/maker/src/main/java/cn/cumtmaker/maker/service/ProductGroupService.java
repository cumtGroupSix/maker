package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.ProductDetailVO;

import java.util.List;

public interface ProductGroupService {
    Integer addProduct(Integer storeId, List<Integer> products);

    List<ProductDetailVO> getDetailByGroupId(Integer groupId);
}
