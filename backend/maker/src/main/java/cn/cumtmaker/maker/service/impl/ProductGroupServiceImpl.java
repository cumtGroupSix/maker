package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.GoodsListVO;
import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.form.ProductFormObject;
import cn.cumtmaker.maker.form.ProductGroupFormObject;
import cn.cumtmaker.maker.form.SpecificationFormObject;
import cn.cumtmaker.maker.mapper.*;
import cn.cumtmaker.maker.model.*;
import cn.cumtmaker.maker.service.ProductGroupService;
import cn.cumtmaker.maker.util.ProductDetailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {

    @Autowired
    ProductGroupMapper productGroupMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    SpecificationMapper specificationMapper;

    @Autowired
    SpecificationValueMapper specificationValueMapper;

    @Autowired
    GroupSpecificationMapper groupSpecificationMapper;

    @Autowired
    ProductValueMapper productValueMapper;

    /**
     * 创客增加商品事务逻辑
     */
    @Override
    public Integer addProduct(Integer storeId, List<Integer> products) {
        int result = 0;
        //判断已选商品是否超过5个
        if (productGroupMapper.selectProductGroupsNumByStoreId(storeId)+products.size()<=5){
            for(Integer productId : products){
                Integer num = productGroupMapper.addProduct(storeId, productId);
                result += num;
            }
        }else{
            throw new RuntimeException("超过商品数量限制");
        }
        return result;
    }

    /**
     * 通过groupId获取所有group中的产品详情
     */
    @Override
    public List<ProductDetailVO> getDetailByGroupId(Integer groupId) {
        List<ProductDetailVO> productDetailVOS = new ArrayList<>();
        List<Integer> productIds = productGroupMapper.getAllProductIdByGroupId(groupId);
        for (Integer productId : productIds){
            productDetailVOS.add(ProductDetailUtil.getDetailByProductId(productId));
        }
        return productDetailVOS;
    }

    @Override
    public List<GoodsListVO> getAll() {
        List<GoodsListVO> goodsListVOS = new ArrayList<>();
        //查找出所有group
        List<ProductGroup> productGroups = productGroupMapper.getAll();
        generateGoodsListVO(goodsListVOS,productGroups);
        return goodsListVOS;
    }

    @Override
    public List<GoodsListVO> getListByCategoryId(Integer categoryId) {
        List<GoodsListVO> goodsListVOS = new ArrayList<>();
        //查找出所有group
        List<ProductGroup> productGroups = productGroupMapper.getGroupsByCategoryId(categoryId);
        generateGoodsListVO(goodsListVOS,productGroups);
        return goodsListVOS;
    }

    private void generateGoodsListVO(List<GoodsListVO> goodsListVOS,List<ProductGroup> productGroups){
        for (ProductGroup productGroup: productGroups){
            GoodsListVO goodsListVO = new GoodsListVO();
            goodsListVO.setGroupId(productGroup.getGroupId());
            ProductDetailVO productDetailVO = ProductDetailUtil.getDetailByProductId(productGroup.getRepresentativeProductId());
            goodsListVO.setImg("<img src=\""+productDetailVO.getImgUrl()+"\" style=\"max-height:100px\">");
            goodsListVO.setName(productDetailVO.getProductName());
            goodsListVO.setPrice(productDetailVO.getPrice());
            String info = "";
            List<Map<String,Object>> maps= productDetailVO.getSpecifications();
            for (Map<String,Object> map : maps){
                info+= map.get("specification")+":"+map.get("specificationValue")+"; ";
            }
            goodsListVO.setInfos(info);
            goodsListVOS.add(goodsListVO);
        }
    }

    @Override
    @Transactional
    public Integer supplierAddProduct(ProductGroupFormObject productGroupFormObject) {
        int result = 0;
        int index = 0;
        int representativeProductId = 0;
        //向group中增加数据
        result += productGroupMapper.insert(productGroupFormObject);
        //向product中增加数据
        for (ProductFormObject productFormObject : productGroupFormObject.getProducts()){
            productFormObject.setGroupId(productGroupFormObject.getGroupId());
            productFormObject.setProductName(productGroupFormObject.getProductName());
            result += productMapper.insert(productFormObject);
            //向specification、specification_value、group_specification、product_value增加数据
            for (SpecificationFormObject specificationFormObject : productFormObject.getSpecifications()){
                Specification specification = new Specification();
                specification.setSpecificationName(specificationFormObject.getSpecificationName());
                //查询是否存在该规格
                Specification selectSpecification = specificationMapper.selectBySpecificationName(specificationFormObject.getSpecificationName());
                if (selectSpecification!=null){
                    specification.setSpecificationId(selectSpecification.getSpecificationId());
                }else {
                    result += specificationMapper.insertSelective(specification);
                }
                SpecificationValue specificationValue = new SpecificationValue();
                specificationValue.setSpecificationId(specification.getSpecificationId());
                specificationValue.setSpecificationValue(specificationFormObject.getSpecificationValue());
                //查询是否存在该规格是否存在该规格值
                SpecificationValue selectSpecificationValue = specificationValueMapper.selectByIdAndValue(specification.getSpecificationId(),specificationFormObject.getSpecificationValue());
                if (selectSpecificationValue!=null){
                    specificationValue.setValueId(selectSpecificationValue.getValueId());
                }else {
                    result += specificationValueMapper.insertSelective(specificationValue);
                }
                if (index == 0){
                    GroupSpecificationKey groupSpecificationKey = new GroupSpecificationKey();
                    groupSpecificationKey.setGroupId(productGroupFormObject.getGroupId());
                    groupSpecificationKey.setSpecificationId(specification.getSpecificationId());
                    result += groupSpecificationMapper.insertSelective(groupSpecificationKey);
                }
                ProductValueKey productValueKey = new ProductValueKey();
                productValueKey.setProductId(productFormObject.getProductId());
                productValueKey.setValueId(specificationValue.getValueId());
                result += productValueMapper.insertSelective(productValueKey);
            }
            if (index == 0){
                representativeProductId = productFormObject.getProductId();
            }
            index++;
        }
        //修改group中representative_product_id
        productGroupMapper.updateRepresentativeProductId(productGroupFormObject.getGroupId(),representativeProductId);
        return result;
    }
}
