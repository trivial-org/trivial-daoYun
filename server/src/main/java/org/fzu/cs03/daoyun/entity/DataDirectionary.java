package org.fzu.cs03.daoyun.entity;

import org.springframework.stereotype.Component;

//@Component
public class DataDirectionary {
    private long dictCode ;
    private String dictName;
    private long dataCode;
    private String dataName;

    public void setDictCode(long dictCode) {
        this.dictCode = dictCode;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public void setDataCode(long dataCode) {
        this.dataCode = dataCode;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public long getDictCode() {
        return dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public long getDataCode() {
        return dataCode;
    }

    public String getDataName() {
        return dataName;
    }
}
