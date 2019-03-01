package cn.cumtmaker.maker.model;

import java.util.Date;

public class Comment {

    private Integer userId;

    private Integer productId;

    private String commentContent;

    private Date commentTime;

    private Integer starLevel1;

    private Integer starLevel2;

    private Integer starLevel3;

    private String imgUrl1;

    private String imgUrl2;

    private String imgUrl3;

    private String imgUrl4;

    //评价的商品
    private Product product;

    //评价的用户
    private User user;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getStarLevel1() {
        return starLevel1;
    }

    public void setStarLevel1(Integer starLevel1) {
        this.starLevel1 = starLevel1;
    }

    public Integer getStarLevel2() {
        return starLevel2;
    }

    public void setStarLevel2(Integer starLevel2) { this.starLevel2 = starLevel2; }

    public Integer getStarLevel3() {
        return starLevel3;
    }

    public void setStarLevel3(Integer starLevel3) {
        this.starLevel3 = starLevel3;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }

    public String getImgUrl4() {
        return imgUrl4;
    }

    public void setImgUrl4(String imgUrl4) {
        this.imgUrl4 = imgUrl4;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}