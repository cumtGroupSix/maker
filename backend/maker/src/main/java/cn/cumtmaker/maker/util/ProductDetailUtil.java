package cn.cumtmaker.maker.util;

import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.mapper.ProductMapper;
import cn.cumtmaker.maker.mapper.SpecificationMapper;
import cn.cumtmaker.maker.mapper.SpecificationValueMapper;
import cn.cumtmaker.maker.model.Product;
import cn.cumtmaker.maker.model.SpecificationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDetailUtil {

    private static ProductMapper productMapper;

    private static SpecificationValueMapper specificationValueMapper;

    private static SpecificationMapper specificationMapper;

    @Autowired
    public ProductDetailUtil(ProductMapper productMapper,SpecificationValueMapper specificationValueMapper,SpecificationMapper specificationMapper){
        this.productMapper=productMapper;
        this.specificationValueMapper=specificationValueMapper;
        this.specificationMapper=specificationMapper;
    }

    /**
     * 通过productId返回产品详情信息
     */
    public static ProductDetailVO getDetailByProductId(Integer productId){
        Product product = productMapper.selectByProductId(productId);
        ProductDetailVO productDetailVO = new ProductDetailVO();
        productDetailVO.setProductId(productId);
        productDetailVO.setImgUrl(product.getImgUrl());
        productDetailVO.setPrice(product.getProductPrice());
        productDetailVO.setProductName(product.getProductName());
        List<Map<String,Object>> specifications = new ArrayList<>();
        //通过productId查找出所有规格值id ——valueId
        List<Integer> valueIds = productMapper.getValueIdsByProductId(productId);
        for (Integer valueId : valueIds){
            SpecificationValue specificationValue = specificationValueMapper.selectByPrimaryKey(valueId);
            Map<String,Object> specification = new HashMap<>();
            specification.put("specification",specificationMapper.selectByPrimaryKey(specificationValue.getSpecificationId()).getSpecificationName());
            specification.put("specificationValue", specificationValue.getSpecificationValue());
            specifications.add(specification);
        }
        //通过valueId查找出规格名称
        productDetailVO.setSpecifications(specifications);
        return productDetailVO;
    }

}
