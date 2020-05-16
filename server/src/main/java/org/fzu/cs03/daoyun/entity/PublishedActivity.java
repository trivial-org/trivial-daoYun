package org.fzu.cs03.daoyun.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/12 21:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "published_activity")
public class PublishedActivity {
    @TableId( type = IdType.ASSIGN_ID )
    private Long id;
    private Long activityTypeId;
    private Long orgId;
    private Boolean isActive;
    private String activityParam;
    private String beginDate;
    private String endDate;
    private Integer maxscore;
    private Double maxDist;
    private String creator;
    private String activityDescription;
    private Double latitude;
    private Double longitude;

    @TableField(exist = false)
    private Long orgCode;

    @TableField(exist = false)
    private String answer;


    @TableField(fill = FieldFill.INSERT)
    private Date creationDate;

    @TableField(fill = FieldFill.UPDATE)
    private Date lastModificationDate;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Boolean isDeleted;



}
