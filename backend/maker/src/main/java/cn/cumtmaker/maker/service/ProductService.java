package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.VO.ProductStockVO;
import cn.cumtmaker.maker.model.Product;

import java.util.List;

public interface ProductService {

    ProductDetailVO getDetailByProductId(Integer productId);
    Integer updateStock(Integer productId,Integer productStock,Integer sales);
    List<ProductStockVO> selectAll();
}
