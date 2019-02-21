package cn.cumtmaker.maker.model;

public class ProductGroup {
    private Integer groupId;

    private String productName;

    private Integer categoryId;

    private Integer representativeProductId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getRepresentativeProductId() {
        return representativeProductId;
    }

    public void setRepresentativeProductId(Integer representativeProductId) {
        this.representativeProductId = representativeProductId;
    }
}
