package net.anjero.pro.module.classify.pojo;

import java.io.Serializable;
import java.util.Date;

public class Classify implements Serializable {
    private Integer id;

    private String classifyName;

    private String classifyIdentify;

    private Integer pid;

    private Integer displayIndex;

    private Boolean isShow;

    private Date inTime;

    private Date modifyTime;

    private Boolean isSys;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public String getClassifyIdentify() {
        return classifyIdentify;
    }

    public void setClassifyIdentify(String classifyIdentify) {
        this.classifyIdentify = classifyIdentify == null ? null : classifyIdentify.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getIsSys() {
        return isSys;
    }

    public void setIsSys(Boolean isSys) {
        this.isSys = isSys;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classifyName=").append(classifyName);
        sb.append(", classifyIdentify=").append(classifyIdentify);
        sb.append(", pid=").append(pid);
        sb.append(", displayIndex=").append(displayIndex);
        sb.append(", isShow=").append(isShow);
        sb.append(", inTime=").append(inTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isSys=").append(isSys);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}