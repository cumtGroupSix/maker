package cn.cumtmaker.maker.VO;

import cn.cumtmaker.maker.model.CartProduct;

public class CartStoreVO {

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    private Integer storeId;

    private String storeName;
}
