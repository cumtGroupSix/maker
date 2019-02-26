package cn.cumtmaker.maker.VO;

public class GroupCollectionVO {
    private StoreVO storeVO;
    private Integer collectedGroupIndex;

    public GroupCollectionVO() {}

    public GroupCollectionVO(StoreVO storeVO, Integer collectedGroupIndex) {
        this.storeVO = storeVO;
        this.collectedGroupIndex = collectedGroupIndex;
    }

    public StoreVO getStoreVO() {
        return storeVO;
    }

    public void setStoreVO(StoreVO storeVO) {
        this.storeVO = storeVO;
    }

    public Integer getCollectedGroupIndex() {
        return collectedGroupIndex;
    }

    public void setCollectedGroupIndex(Integer collectedGroupIndex) {
        this.collectedGroupIndex = collectedGroupIndex;
    }
}
