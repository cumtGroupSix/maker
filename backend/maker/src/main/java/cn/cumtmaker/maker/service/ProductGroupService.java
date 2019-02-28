package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.GoodsListVO;
import cn.cumtmaker.maker.VO.ProductDetailVO;
import cn.cumtmaker.maker.VO.ProductGroupDetailVO;
import cn.cumtmaker.maker.form.ProductGroupFormObject;

import java.util.ArrayList;
import java.util.List;

public interface ProductGroupService {
    Integer addProduct(Integer storeId, List<Integer> products);

    List<ProductDetailVO> getDetailByGroupId(Integer groupId);

    List<GoodsListVO> getAll();

    List<GoodsListVO> getListByCategoryId(Integer categoryId);

    Integer supplierAddProduct(ProductGroupFormObject productGroupFormObject);

    List<GoodsListVO> getListByCategoryName(String categoryName);

    List<ProductDetailVO> getDetailByProductName(String productName);

    Integer supplierUpdate(ProductGroupDetailVO productGroupDetailVO);

    Integer supplierDelete(Integer groupId);

    List<ProductGroupDetailVO> getGroupDetailByCategoryId(Integer categoryId);
}
