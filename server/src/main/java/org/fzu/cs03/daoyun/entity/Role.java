package org.fzu.cs03.daoyun.entity;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Role {

    static public final Long SUPER_ADMIN = 1L;
    static public final Long VIP_USER = 2L;
    static public final Long ORDINARY_USER = 3L;

    private Long roleId;
    private Long roleTemplateId;
    private boolean isTemplate;
    private Long roleCode;
    private String roleName;
    private String creationDate;

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleTemplateId(Long roleTemplateId) {
        this.roleTemplateId = roleTemplateId;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public void setRoleCode(Long roleCode) {
        this.roleCode = roleCode;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public static Long getSuperAdmin() {
        return SUPER_ADMIN;
    }

    public static Long getVipUser() {
        return VIP_USER;
    }

    public static Long getOrdinaryUser() {
        return ORDINARY_USER;
    }

    public Long getRoleId() {
        return roleId;
    }

    public Long getRoleTemplateId() {
        return roleTemplateId;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public Long getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getCreationDate() {
        return creationDate;
    }
}
