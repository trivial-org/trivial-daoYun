package org.fzu.cs03.daoyun.entity;

/**
 * @description: 该实体描述了一个用户的简单描述，仅包含用户的非敏感信息
 * @author: Mu.xx
 * @date: 2020/4/15 14:44
 */
public class SimpleUserInfo {
    private Long userId;
    private String userName;
    private String nickName;
    private String studentId;
    private String school,education,major;
    private String birthDate;
    private String address,city,province,nation;
    private String profilePhotoUrl;
    private String college;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSchool() {
        return school;
    }

    public String getEducation() {
        return education;
    }

    public String getMajor() {
        return major;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getNation() {
        return nation;
    }
}
