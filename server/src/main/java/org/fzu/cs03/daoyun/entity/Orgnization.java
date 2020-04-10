package org.fzu.cs03.daoyun.entity;

public class Orgnization {
    private Long orgCode;
    private String orgName;
    private String creationDate;
    private Long richTextId;
    private String creator;

    public void setOrgCode(Long orgCode) {
        this.orgCode = orgCode;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setRichTextId(Long richTextId) {
        this.richTextId = richTextId;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getOrgCode() {
        return orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Long getRichTextId() {
        return richTextId;
    }

    public String getCreator() {
        return creator;
    }
}
