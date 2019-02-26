package cn.cumtmaker.maker.VO;

public class GroupEvaluationVO {
    private StoreVO storeVO;
    private Integer groupIndex;
    private Float valueDisabled;

    public GroupEvaluationVO() {}

    public GroupEvaluationVO(StoreVO storeVO, Integer groupIndex, Float valueDisabled) {
        this.storeVO = storeVO;
        this.groupIndex = groupIndex;
        this.valueDisabled = valueDisabled;
    }

    public StoreVO getStoreVO() {
        return storeVO;
    }

    public void setStoreVO(StoreVO storeVO) {
        this.storeVO = storeVO;
    }

    public Integer getGroupIndex() {
        return groupIndex;
    }

    public void setGroupIndex(Integer groupIndex) {
        this.groupIndex = groupIndex;
    }

    public Float getValueDisabled() {
        return valueDisabled;
    }

    public void setValueDisabled(Float valueDisabled) {
        this.valueDisabled = valueDisabled;
    }
}
