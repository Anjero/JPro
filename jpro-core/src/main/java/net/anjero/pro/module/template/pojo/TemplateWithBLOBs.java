package net.anjero.pro.module.template.pojo;

import java.io.Serializable;

public class TemplateWithBLOBs extends Template implements Serializable {
    private String remark;

    private String headerScript;

    private String footerScript;

    private static final long serialVersionUID = 1L;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHeaderScript() {
        return headerScript;
    }

    public void setHeaderScript(String headerScript) {
        this.headerScript = headerScript == null ? null : headerScript.trim();
    }

    public String getFooterScript() {
        return footerScript;
    }

    public void setFooterScript(String footerScript) {
        this.footerScript = footerScript == null ? null : footerScript.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", remark=").append(remark);
        sb.append(", headerScript=").append(headerScript);
        sb.append(", footerScript=").append(footerScript);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}