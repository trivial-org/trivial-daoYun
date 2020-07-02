package org.fzu.cs03.daoyun.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/7/2 18:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity_UserState {
    private Long userId;
    private Long activityId;
    private Long activityTypeId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate;

}
