package org.fzu.cs03.daoyun.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/16 21:08
 */
public class AttendClassActivity {
    private String attender;
    private Long activityId;
    private String attendDate;
    private JSONObject jsonAnswer;
    private Boolean isGroupAttend;

    public void setAttender(String attender) {
        this.attender = attender;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public void setAttendDate(String attendDate) {
        this.attendDate = attendDate;
    }

    public void setJsonAnswer(JSONObject jsonAnswer) {
        this.jsonAnswer = jsonAnswer;
    }

    public void setGroupAttend(Boolean groupAttend) {
        isGroupAttend = groupAttend;
    }

    public String getAttender() {
        return attender;
    }

    public Long getActivityId() {
        return activityId;
    }

    public String getAttendDate() {
        return attendDate;
    }

    public JSONObject getJsonAnswer() {
        return jsonAnswer;
    }

    public Boolean getGroupAttend() {
        return isGroupAttend;
    }
}
