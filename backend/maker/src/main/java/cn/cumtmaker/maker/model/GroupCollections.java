package cn.cumtmaker.maker.model;

public class GroupCollections {
    private Integer userId;
    private Integer storeId;

    /**
     * 收藏商品ID
     */
    private Integer collectGroupId;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取创客店ID
     *
     * @return store_id - 创客店ID
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置创客店ID
     *
     * @param storeId 创客店ID
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取收藏商品ID
     *
     * @return collect_group_id - 收藏商品ID
     */
    public Integer getCollectGroupId() {
        return collectGroupId;
    }

    /**
     * 设置收藏商品ID
     *
     * @param collectGroupId 收藏商品ID
     */
    public void setCollectGroupId(Integer collectGroupId) {
        this.collectGroupId = collectGroupId;
    }
}