package org.fzu.cs03.daoyun.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgMemberScore {

    private Long userId;
    private String username;
    private Long studentId;

    @TableField(exist = false)
    private String sumScore;//是否参与


}
