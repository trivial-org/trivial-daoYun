package org.fzu.cs03.daoyun.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName(value = "role")
public class Role {

    static public final Long SUPER_ADMIN = 1L;
    static public final Long VIP_USER = 2L;
    static public final Long ORDINARY_USER = 3L;

    private Long id;
    private Long roleTemplateId;
    private Boolean isTemplate;
    private Long roleCode;
    private String roleName;
    private String roleDescription;

    @TableField(fill = FieldFill.INSERT)
    private String creator;

    @TableField(fill = FieldFill.UPDATE)
    private String lastModifier;

    @TableField(fill = FieldFill.INSERT)
    private Date creationDate;

    @TableField(fill = FieldFill.UPDATE)
    private Date lastModificationDate;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Boolean isDeleted;


}
