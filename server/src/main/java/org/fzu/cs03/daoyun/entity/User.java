package org.fzu.cs03.daoyun.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
/**
 * @description: 该实体描述了user表对应的所有字段，只内部可见
 * @author: Mu.xx
 * @date: 2020/4/15 14:48
 * @param: null
 * @return:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName(value = "user")
public class User {
    private Long id;
    private Long roleId;
    private String username;
    private String nickname;
    private String studentId;

    private String phone;
    private String email;
    private String school,education,major;
    private String birthDate;
    private String address,city,province,nation;
    private Integer experience,coin;
    private String profilePhotoUrl;
    private String college;

    private Boolean isActive;


    //可以输入，但是不能从数据库中读取得到，因此从数据库读出时应该置空
    private String password;


    @TableField(exist = false)
    private String verificationCode;

    @TableField(exist = false)
    private String mailVerificationCode;



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
