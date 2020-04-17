package org.fzu.cs03.daoyun.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/16 21:05
 */
public class ClassActivity {
    private String publisher;
    private Long orgCode;
    private String publishDate;
    private String description;
    private JSONObject jsonAnswer;
    private Long activityType;
    private String activityTypeName;
    private Boolean isGroupActivity;

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setOrgCode(Long orgCode) {
        this.orgCode = orgCode;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setJsonAnswer(JSONObject jsonAnswer) {
        this.jsonAnswer = jsonAnswer;
    }

    public void setActivityType(Long activityType) {
        this.activityType = activityType;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public void setGroupActivity(Boolean groupActivity) {
        isGroupActivity = groupActivity;
    }

    public String getPublisher() {
        return publisher;
    }

    public Long getOrgCode() {
        return orgCode;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getDescription() {
        return description;
    }

    public JSONObject getJsonAnswer() {
        return jsonAnswer;
    }

    public Long getActivityType() {
        return activityType;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public Boolean getGroupActivity() {
        return isGroupActivity;
    }
}
