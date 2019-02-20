package cn.cumtmaker.maker.form;

import java.util.List;

public class ProductFormObject {

    Integer productId;

    String productName;

    Integer stock;

    Integer price;

    String description;

    String imageUrl;

    Integer groupId;

    List<SpecificationFormObject> specifications;

    public List<SpecificationFormObject> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<SpecificationFormObject> specifications) {
        this.specifications = specifications;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
