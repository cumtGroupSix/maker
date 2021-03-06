package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.VO.ProductStockVO;
import cn.cumtmaker.maker.mapper.ProductMapper;
import cn.cumtmaker.maker.mapper.SpecificationMapper;
import cn.cumtmaker.maker.mapper.SpecificationValueMapper;
import cn.cumtmaker.maker.model.Product;
import cn.cumtmaker.maker.model.SpecificationValue;
import cn.cumtmaker.maker.service.ProductService;
import cn.cumtmaker.maker.util.ProductDetailUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    SpecificationValueMapper specificationValueMapper;

    @Autowired
    SpecificationMapper specificationMapper;

    /**
     * 通过产品id返回产品主要参数
     * @param productId
     * @return
     */
    @Override
    public ProductDetailVO getDetailByProductId(Integer productId) {
        return ProductDetailUtil.getDetailByProductId(productId);
    }

    /**
     * 更新商品库存
     * @param productId
     * @param productStock
     * @return
     */
    @Override
    public Integer updateStock(Integer productId,Integer productStock,Integer sales){
        return productMapper.updateStock(productId,productStock,sales);
    }

    /**
     * 获取库存销售数量
     * @return
     */
    @Override
    public List<ProductStockVO> selectAll(){
        List<Product> list=productMapper.selectAll();
        return toProductStockVO(list);
    }

    /**
     * 转化为ProductStockVO
     * @param productlist
     * @return
     */
    private List<ProductStockVO> toProductStockVO(List<Product> productlist){
        List<ProductStockVO> productStockVOS=new ArrayList<>();
        for(Product product : productlist){
            ProductStockVO productStockVO=new ProductStockVO();
            BeanUtils.copyProperties(product,productStockVO);
            productStockVOS.add(productStockVO);
        }
        return productStockVOS;
    }
}
