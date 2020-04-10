package org.fzu.cs03.daoyun.entity;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/9 20:23
 */


public class RequestUser {
    private long userId;
    private String userName;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
