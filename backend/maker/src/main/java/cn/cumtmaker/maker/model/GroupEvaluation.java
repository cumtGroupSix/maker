package cn.cumtmaker.maker.model;

public class GroupEvaluation {
    private int userId;
    private int storeId;
    private int groupId;
    private float valueDisabled;

    public GroupEvaluation(){}

    public GroupEvaluation(int userId, int storeId, int groupId, float valueDisabled) {
        this.userId = userId;
        this.storeId = storeId;
        this.groupId = groupId;
        this.valueDisabled = valueDisabled;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public float getValueDisabled() {
        return valueDisabled;
    }

    public void setValueDisabled(float valueDisabled) {
        this.valueDisabled = valueDisabled;
    }
}
