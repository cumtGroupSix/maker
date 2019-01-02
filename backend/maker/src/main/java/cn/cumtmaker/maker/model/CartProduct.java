package cn.cumtmaker.maker.model;

import cn.cumtmaker.maker.VO.CartStoreVO;


public class CartProduct {

    private Integer cartId;

    private Integer storeId;

    private Integer productId;

    private Integer productQuantity;


    public CartStoreVO getStore() {
        return store;
    }

    public void setStore(CartStoreVO store) {
        this.store = store;
    }

    private CartStoreVO store;

    private Product product;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}