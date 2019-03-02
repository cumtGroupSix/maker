package cn.cumtmaker.maker.VO;

import java.util.List;

public class ProductGroupDetailVO {

    Integer groupId;

    String name;

    List<ProductDetailVO> products;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDetailVO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailVO> products) {
        this.products = products;
    }
}
