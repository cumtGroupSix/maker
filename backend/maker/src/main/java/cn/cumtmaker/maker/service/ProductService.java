package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.ProductDetailVO;

public interface ProductService {

    ProductDetailVO getDetailByProductId(Integer productId);

}
