package cn.cumtmaker.maker.VO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ProductDetailVO {

    Integer productId;

    BigDecimal price;

    String productName;

    String imgUrl;

    List<Map<String,Object>> specifications;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Map<String, Object>> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Map<String, Object>> specifications) {
        this.specifications = specifications;
    }
}
