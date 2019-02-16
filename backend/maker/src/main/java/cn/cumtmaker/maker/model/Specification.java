package cn.cumtmaker.maker.model;

import java.io.Serializable;

/**
 * specification
 * @author 
 */
public class Specification implements Serializable {
    private Integer specificationId;

    private String specificationName;

    private static final long serialVersionUID = 1L;

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Specification other = (Specification) that;
        return (this.getSpecificationId() == null ? other.getSpecificationId() == null : this.getSpecificationId().equals(other.getSpecificationId()))
            && (this.getSpecificationName() == null ? other.getSpecificationName() == null : this.getSpecificationName().equals(other.getSpecificationName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecificationId() == null) ? 0 : getSpecificationId().hashCode());
        result = prime * result + ((getSpecificationName() == null) ? 0 : getSpecificationName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", specificationId=").append(specificationId);
        sb.append(", specificationName=").append(specificationName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}