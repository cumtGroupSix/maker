package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.GoodsListVO;
import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.VO.ProductGroupDetailVO;
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

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CartProductMapper cartProductMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    GroupCollectionsMapper groupCollectionsMapper;

    @Autowired
    StoreProductMapper storeProductMapper;

    /**
     * 创客增加商品事务逻辑
     * @param storeId
     * @param products
     * @return
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
     * @param groupId
     * @return
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

    /**
     * 查找所有产品列表
     * @return
     */
    @Override
    public List<GoodsListVO> getAll() {
        List<GoodsListVO> goodsListVOS = new ArrayList<>();
        //查找出所有group
        List<ProductGroup> productGroups = productGroupMapper.getAll();
        generateGoodsListVO(goodsListVOS,productGroups);
        return goodsListVOS;
    }

    /**
     * 查出该类目所有产品列表
     * @param categoryId
     * @return
     */
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

    /**
     * 供应商增添商品逻辑
     * @param productGroupFormObject
     * @return
     */
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

    /**
     * 通过类目名查找所有商品
     * @param categoryName
     * @return
     */
    @Override
    public List<GoodsListVO> getListByCategoryName(String categoryName) {
        List<GoodsListVO> goodsListVOS = new ArrayList<>();
        //查出categoryName对应的id
        Integer categoryId = categoryMapper.getCategoryIdByName(categoryName);
        //查找出所有group
        List<ProductGroup> productGroups = productGroupMapper.getGroupsByCategoryId(categoryId);
        generateGoodsListVO(goodsListVOS,productGroups);
        return goodsListVOS;
    }

    /**
     * 通过group的名称查找组内所有产品详情
     * @param productName
     * @return
     */
    @Override
    public List<ProductDetailVO> getDetailByProductName(String productName) {
        List<ProductDetailVO> productDetailVOS = new ArrayList<>();
        //通过productName获取groupId
        List<Integer> groupIds = productGroupMapper.getGroupIdByProductName(productName);
        //获取list integer 通过productName
        if (groupIds.size() != 0){
            List<Integer> productIds = productGroupMapper.getAllProductIdByGroupId(groupIds.get(0));
            for(Integer productId : productIds){
                productDetailVOS.add(ProductDetailUtil.getDetailByProductId(productId));
            }
            return productDetailVOS;
        }else {
            return null;
        }
    }

    /**
     * 供应商修改商品逻辑
     * @param productGroupDetailVO
     * @return
     */
    @Override
    @Transactional
    public Integer supplierUpdate(ProductGroupDetailVO productGroupDetailVO) {
        Integer result = 0;
        result += productGroupMapper.updateProductNameByGroupId(productGroupDetailVO.getGroupId(),productGroupDetailVO.getName());
        for (ProductDetailVO productDetailVO : productGroupDetailVO.getProducts()){
            result += productMapper.updateByProductId(productDetailVO.getProductId(),productDetailVO.getPrice(),productDetailVO.getStock(),productDetailVO.getProductName());
        }
        return result;
    }

    /**
     * 供应商删除商品接口
     * @param groupId
     * @return
     */
    @Override
    public Integer supplierDelete(Integer groupId) {
        Integer result = 0;
        List<Integer> productIds = productGroupMapper.getAllProductIdByGroupId(groupId);
        for (Integer productId : productIds){
            //删除cart_product中所有product有关数据
            result += cartProductMapper.deleteByProductId(productId);
            //删除comment中所有product有关数据
            result += commentMapper.deleteByProductId(productId);
            //删除order_detail中所有product有关数据
            result += orderDetailMapper.deleteByProductId(productId);
            //删除product_value中所有product有关数据
            result += productValueMapper.deleteByProductId(productId);
            //删除product
            result += productMapper.deleteByProductId(productId);
        }

        //删除group_collection中所有groupId有关数据
        result += groupCollectionsMapper.deleteByGroupId(groupId);
        //删除group_specification中所有groupId有关数据
        result += groupSpecificationMapper.deleteByGroupId(groupId);
        //删除store_group中所有groupId有关数据
        result += storeProductMapper.deleteByGroupId(groupId);
        //删除group
        result += productGroupMapper.deleteByGroupId(groupId);
        return result;
    }

    /**
     * 通过类目id获取所有group详情
     * @param categoryId
     * @return
     */
    @Override
    public List<ProductGroupDetailVO> getGroupDetailByCategoryId(Integer categoryId) {
        List<ProductGroupDetailVO> productGroupDetailVOS = new ArrayList<>();
        List<Integer> groupIds = productGroupMapper.getGroupIdsByCategoryId(categoryId);
        for (Integer groupId: groupIds){
            ProductGroupDetailVO productGroupDetailVO = new ProductGroupDetailVO();
            productGroupDetailVO.setGroupId(groupId);
            productGroupDetailVO.setName(productGroupMapper.getProductNameByGroupId(groupId));
            List<Integer> productIds = productGroupMapper.getAllProductIdByGroupId(groupId);
            List<ProductDetailVO> productDetailVOS = new ArrayList<>();
            for (Integer productId : productIds){
                ProductDetailVO productDetailVO = ProductDetailUtil.getDetailByProductId(productId);
                productDetailVOS.add(productDetailVO);
            }
            productGroupDetailVO.setProducts(productDetailVOS);
            productGroupDetailVOS.add(productGroupDetailVO);
        }
        return productGroupDetailVOS;
    }
}
