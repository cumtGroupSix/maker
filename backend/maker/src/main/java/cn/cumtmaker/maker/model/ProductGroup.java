package cn.cumtmaker.maker.model;

public class ProductGroup {
    private Integer groupId;

    private String productName;

    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRepresentativeProductId() {
        return representativeProductId;
    }

    public void setRepresentativeProductId(Integer representativeProductId) {
        this.representativeProductId = representativeProductId;
    }
}
