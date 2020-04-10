package org.fzu.cs03.daoyun.entity;

import org.springframework.stereotype.Component;

//@Component
public class DataDirectionary {
    private Long dictCode ;
    private String dictName;
    private Long dataCode;
    private String dataName;

    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public void setDataCode(Long dataCode) {
        this.dataCode = dataCode;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public Long getDictCode() {
        return dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public Long getDataCode() {
        return dataCode;
    }

    public String getDataName() {
        return dataName;
    }
}
