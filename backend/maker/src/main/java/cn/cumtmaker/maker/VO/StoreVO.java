package cn.cumtmaker.maker.VO;

import java.util.List;

public class StoreVO {
    private Integer storeId;

    private String storeName;

    private String storeIntroduce;

    private Integer browseTimes;

    private String imgUrl;

    private List<ProductGroupVO> productGroupVOS;

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

    public String getStoreIntroduce() {
        return storeIntroduce;
    }

    public void setStoreIntroduce(String storeIntroduce) {
        this.storeIntroduce = storeIntroduce;
    }

    public List<ProductGroupVO> getProductGroupVOS() {
        return productGroupVOS;
    }

    public void setProductGroupVOS(List<ProductGroupVO> productGroupVOS) {
        this.productGroupVOS = productGroupVOS;
    }

    public Integer getBrowseTimes() {
        return browseTimes;
    }

    public void setBrowseTimes(Integer browseTimes) {
        this.browseTimes = browseTimes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
