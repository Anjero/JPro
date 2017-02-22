package net.anjero.pro.module.seo.pojo;

import java.io.Serializable;

public class SeoWithBLOBs extends Seo implements Serializable {
    private String description;

    private String keywords;

    private String headerScript;

    private String footerScript;

    private static final long serialVersionUID = 1L;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
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
        sb.append(", description=").append(description);
        sb.append(", keywords=").append(keywords);
        sb.append(", headerScript=").append(headerScript);
        sb.append(", footerScript=").append(footerScript);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}