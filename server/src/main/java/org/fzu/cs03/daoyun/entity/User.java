package org.fzu.cs03.daoyun.entity;

import org.springframework.stereotype.Component;

@Component
/**
 * @description: 该实体描述了user表对应的所有字段，只内部可见
 * @author: Mu.xx
 * @date: 2020/4/15 14:48
 * @param: null
 * @return:
 */
public class User {
    private long userId;
    private long roleId;
    private String userName;
    private String nickName;
    private String studentId;
    private String password;
    private String phone;
    private String email;
    private String school,education,major;
    private String birthDate;
    private String address,city,province,nation;
    private int experience,coin;
    private String profilePhotoUrl;

    private String mobileToken,webToken,pcToken;
    private String mobileTokenCreateDate,webTokenCreateDate,pcTokenCreateDate;
    private String mobileTokenEndDate,webTokenEndDate,pcTokenEndDate;

    private String verificationCode;
    private String mailVerificationCode;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setMailVerificationCode(String mailVerificationCode) {
        this.mailVerificationCode = mailVerificationCode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setMobileToken(String mobileToken) {
        this.mobileToken = mobileToken;
    }

    public void setWebToken(String webToken) {
        this.webToken = webToken;
    }

    public void setPcToken(String pcToken) {
        this.pcToken = pcToken;
    }

    public void setMobileTokenCreateDate(String mobileTokenCreateDate) {
        this.mobileTokenCreateDate = mobileTokenCreateDate;
    }

    public void setWebTokenCreateDate(String webTokenCreateDate) {
        this.webTokenCreateDate = webTokenCreateDate;
    }

    public void setPcTokenCreateDate(String pcTokenCreateDate) {
        this.pcTokenCreateDate = pcTokenCreateDate;
    }

    public void setMobileTokenEndDate(String mobileTokenEndDate) {
        this.mobileTokenEndDate = mobileTokenEndDate;
    }

    public void setWebTokenEndDate(String webTokenEndDate) {
        this.webTokenEndDate = webTokenEndDate;
    }

    public void setPcTokenEndDate(String pcTokenEndDate) {
        this.pcTokenEndDate = pcTokenEndDate;
    }

    public long getUserId() {
        return userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
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

    public int getExperience() {
        return experience;
    }

    public int getCoin() {
        return coin;
    }

    public String getMobileToken() {
        return mobileToken;
    }

    public String getWebToken() {
        return webToken;
    }

    public String getPcToken() {
        return pcToken;
    }

    public String getMobileTokenCreateDate() {
        return mobileTokenCreateDate;
    }

    public String getWebTokenCreateDate() {
        return webTokenCreateDate;
    }

    public String getPcTokenCreateDate() {
        return pcTokenCreateDate;
    }

    public String getMobileTokenEndDate() {
        return mobileTokenEndDate;
    }

    public String getWebTokenEndDate() {
        return webTokenEndDate;
    }

    public String getPcTokenEndDate() {
        return pcTokenEndDate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public String getMailVerificationCode() {
        return mailVerificationCode;
    }

    public String getPassword() {
        return password;
    }
}
