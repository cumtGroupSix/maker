package cn.cumtmaker.maker.form;

import java.util.List;

public class ProductGroupFormObject {

    Integer groupId;

    Integer categoryId;

    String productName;

    List<ProductFormObject> products;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProductFormObject> getProducts() {
        return products;
    }

    public void setProducts(List<ProductFormObject> products) {
        this.products = products;
    }
}
