package cn.cumtmaker.maker.util;

import cn.cumtmaker.maker.VO.ProductGroupVO;
import cn.cumtmaker.maker.VO.ProductVO;
import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.mapper.ProductGroupMapper;
import cn.cumtmaker.maker.mapper.ProductMapper;
import cn.cumtmaker.maker.model.Product;
import cn.cumtmaker.maker.model.ProductGroup;
import cn.cumtmaker.maker.model.Store;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreVOUtil {
    private static ProductGroupMapper productGroupMapper;

    private static ProductMapper productMapper;

    @Autowired
    public StoreVOUtil(ProductGroupMapper productGroupMapper,ProductMapper productMapper) {
        this.productGroupMapper = productGroupMapper;
        this.productMapper=productMapper;
    }

    public static StoreVO create(Store store){
        //通过storeId查找List<ProductGroup>
        List<ProductGroup> productGroups= productGroupMapper.selectProductGroupsByStoreId(store.getStoreId());
        //通过ProductGroup中的representativeProductId创建新的ProductGroupVO List
        List<ProductGroupVO> productGroupVOS=new ArrayList<>();
        for (ProductGroup productGroup: productGroups){
            ProductGroupVO productGroupVO = new ProductGroupVO();
            BeanUtils.copyProperties(productGroup,productGroupVO);
            Product product =productMapper.selectByProductId(productGroup.getRepresentativeProductId());
            ProductVO productVO = convertProductToProductVO(product);
            productGroupVO.setProductVO(productVO);
            productGroupVOS.add(productGroupVO);
        }
        //将Store中的属性用BeanUtil放入StoreVO
        StoreVO storeVO= new StoreVO();
        BeanUtils.copyProperties(store,storeVO);
        //将ProductGroupVO放入StoreVO
        storeVO.setProductGroupVOS(productGroupVOS);

        return storeVO;
    }

    public static ProductVO convertProductToProductVO(Product product){
        if (product == null){
            return null;
        }
        ProductVO productVO = new ProductVO();
        BeanUtils.copyProperties(product,productVO);
        return productVO;
    }
}
