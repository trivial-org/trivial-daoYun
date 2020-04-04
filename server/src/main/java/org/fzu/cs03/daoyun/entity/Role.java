package org.fzu.cs03.daoyun.entity;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Role {

    static public final int SUPER_ADMIN = 1;
    static public final int VIP_USER = 2;
    static public final int ORDINARY_USER = 3;

    private long roleId;
    private long roleTemplateId;
    private boolean isTemplate;
    private long roleCode;
    private String roleName;
    private String creationDate;

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public void setRoleTemplateId(long roleTemplateId) {
        this.roleTemplateId = roleTemplateId;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public void setRoleCode(long roleCode) {
        this.roleCode = roleCode;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public long getRoleId() {
        return roleId;
    }

    public long getRoleTemplateId() {
        return roleTemplateId;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public long getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getCreationDate() {
        return creationDate;
    }
}
