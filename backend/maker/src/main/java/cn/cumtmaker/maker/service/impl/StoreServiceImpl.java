package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.ProductVO;
import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.mapper.ProductGroupMapper;
import cn.cumtmaker.maker.mapper.ProductMapper;
import cn.cumtmaker.maker.mapper.StoreMapper;
import cn.cumtmaker.maker.mapper.StoreProductMapper;
import cn.cumtmaker.maker.model.Product;
import cn.cumtmaker.maker.model.ProductGroup;
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

    @Autowired
    StoreProductMapper storeProductMapper;

    @Autowired
    ProductGroupMapper productGroupMapper;

    /**
     * 获取热门店铺
     * @return
     */
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

    public Integer updateStore(Integer storeId,String storeName,String storeIntroduce,String imgUrl){
        return storeMapper.updateStore(storeId,storeName,storeIntroduce,imgUrl);
    }

    /**
     * 通过类目id获取所有拥有此类产品的商铺
     * @param categoryId
     * @return
     */
    @Override
    public List<StoreVO> getStoresByCategoryId(Integer categoryId) {
        List<StoreVO> storeVOS = new ArrayList<>();
        //从product_group中查出所有该category的group
        List<ProductGroup> productGroups = productGroupMapper.getGroupsByCategoryId(categoryId);
        //每个group查找拥有它的store
        for (ProductGroup productGroup : productGroups){
            for (Integer storeId : storeProductMapper.getStoreIdsByGroupId(productGroup.getGroupId())){
                Boolean result = true;
                for (StoreVO storeVO : storeVOS){
                    if (storeVO.getStoreId() == storeId){
                        result = false;
                    }
                }
                //判断store是否已存在于storeVOS中
                if (result == true){
                    //拼装storeVO
                    StoreVO storeVO = StoreVOUtil.create(storeMapper.selectById(storeId));
                    storeVOS.add(storeVO);
                }
            }
        }
        return storeVOS;
    }
}
